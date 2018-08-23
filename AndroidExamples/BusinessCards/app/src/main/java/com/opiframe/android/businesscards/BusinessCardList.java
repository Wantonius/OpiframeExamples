package com.opiframe.android.businesscards;

import android.content.Context;
import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_business_card_list);
        addButton = (Button)findViewById(R.id.addbutton);
        lw = (ListView)findViewById(R.id.lw);
        adapter = new BusinessCardAdapter(this,0,0);
        lw.setAdapter(adapter);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==100){
            if(resultCode==RESULT_OK) {
                BusinessCard tempCard = new BusinessCard();
                tempCard.setFirstName(data.getStringExtra("firstname"));
                tempCard.setLastName(data.getStringExtra("lastname"));
                tempCard.setTitle(data.getStringExtra("title"));
                tempCard.setPhone(data.getStringExtra("phone"));
                tempCard.setCompany(data.getStringExtra("company"));
                adapter.add(tempCard);
                adapter.notifyDataSetChanged();
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
