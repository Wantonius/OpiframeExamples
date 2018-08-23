package com.opiframe.android.businesscards;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BusinessCardList extends AppCompatActivity {

    private static final String TAG = "BusinessCardList";
    private ListView lw;
    private Button addButton;
    private BusinessCardAdapter adapter;
    private ContentResolver resolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_business_card_list);
        resolver = getContentResolver();
        addButton = (Button)findViewById(R.id.addbutton);
        lw = (ListView)findViewById(R.id.lw);
        adapter = new BusinessCardAdapter(this,0,0);
        lw.setAdapter(adapter);
        Cursor c = resolver.query(BusinessCard.CONTENT_URI, null,null,null,null);
        if(c.getCount() > 0) {
            this.getDatabaseContent(c);
        }
        lw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(BusinessCardList.this,ShowSingleCard.class);
                BusinessCard temp = adapter.getItem(i);
                intent.putExtra("title",temp.getTitle());
                intent.putExtra("firstname",temp.getFirstName());
                intent.putExtra("lastname",temp.getLastName());
                intent.putExtra("company", temp.getCompany());
                intent.putExtra("phone",temp.getPhone());
                intent.putExtra("position", i);
                startActivityForResult(intent,200);
                return true;
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"addButton - onClick");
                Intent i = new Intent(BusinessCardList.this,AddNewCard.class);
                startActivityForResult(i,100);
            }
        });
    }

    private void getDatabaseContent(Cursor c) {
        c.moveToFirst();
        while(c.moveToNext()) {
            BusinessCard temp = new BusinessCard();
            temp.setFirstName(c.getString(c.getColumnIndex(BusinessCard.FIRST_NAME)));
            temp.setLastName(c.getString(c.getColumnIndex(BusinessCard.LAST_NAME)));
            temp.setCompany(c.getString(c.getColumnIndex(BusinessCard.COMPANY)));
            temp.setPhone(c.getString(c.getColumnIndex(BusinessCard.PHONE)));
            temp.setId(c.getInt(c.getColumnIndex(BusinessCard._ID)));
            temp.setTitle(c.getString(c.getColumnIndex(BusinessCard.TITLE)));
            adapter.add(temp);
        }
        adapter.notifyDataSetChanged();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==100){
            if(resultCode==RESULT_OK) {
                ContentValues v = new ContentValues();
                v.put(BusinessCard.FIRST_NAME, data.getStringExtra("firstname"));
                v.put(BusinessCard.LAST_NAME, data.getStringExtra("lastname"));
                v.put(BusinessCard.COMPANY,data.getStringExtra("company"));
                v.put(BusinessCard.TITLE,data.getStringExtra("title"));
                v.put(BusinessCard.PHONE,data.getStringExtra("phone"));
                resolver.insert(BusinessCard.CONTENT_URI, v);
                Cursor c = resolver.query(BusinessCard.CONTENT_URI, null,null,null,null);
                if(c.getCount() > 0) {
                    adapter.clear();
                    getDatabaseContent(c);
                }

            }
        }
        if(requestCode==200) {
            if(resultCode == RESULT_OK) {
                int pos = data.getIntExtra("position",-1);
                BusinessCard temp = adapter.getItem(pos);
                adapter.remove(temp);
                adapter.notifyDataSetChanged();
            }
        }
    }

    private class BusinessCardAdapter extends ArrayAdapter<BusinessCard> {

        public BusinessCardAdapter(@NonNull Context context, int resource) {
            super(context, resource);
        }

        public BusinessCardAdapter(@NonNull Context context, int resource, int textViewResourceId) {
            super(context, resource, textViewResourceId);
        }

        public BusinessCardAdapter(@NonNull Context context, int resource, @NonNull BusinessCard[] objects) {
            super(context, resource, objects);
        }

        public BusinessCardAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull BusinessCard[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        public BusinessCardAdapter(@NonNull Context context, int resource, @NonNull List<BusinessCard> objects) {
            super(context, resource, objects);
        }

        public BusinessCardAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<BusinessCard> objects) {
            super(context, resource, textViewResourceId, objects);
        }

        public View getView(int pos, View convertView, ViewGroup parent) {
            View v = convertView;
            if(v == null) {
                v = getLayoutInflater().inflate(R.layout.businesscard_listrow,null);
            }
            TextView companyText = (TextView)v.findViewById(R.id.listviewrowcompanyinfo);
            TextView firstNameText = (TextView)v.findViewById(R.id.firstnamerowinfo);
            TextView lastNameText = (TextView)v.findViewById(R.id.lastnamerowinfo);
            BusinessCard temp = adapter.getItem(pos);
            companyText.setText(temp.getCompany());
            firstNameText.setText(temp.getFirstName());
            lastNameText.setText(temp.getLastName());
            return v;
        }
    }
}
