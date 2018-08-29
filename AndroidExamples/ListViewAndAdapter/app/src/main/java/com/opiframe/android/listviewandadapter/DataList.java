package com.opiframe.android.listviewandadapter;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class DataList extends AppCompatActivity {

    private ContactCardAdapter adapter;
    private Button addButton;
    private ListView lw;
    private ContentResolver resolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        addButton = findViewById(R.id.addButton);
        resolver = getContentResolver();
        lw = findViewById(R.id.contactListView);
        adapter = new ContactCardAdapter(this,0,0);
        lw.setAdapter(adapter);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DataList.this, Details.class);
                startActivityForResult(i,100);
            }
        });
        lw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact temp = adapter.getItem(i);
                Intent intent = new Intent(DataList.this,ContactCard.class);
                intent.putExtra("firstName",temp.getFirstName());
                intent.putExtra("lastName",temp.getLastName());
                intent.putExtra("title",temp.getTitle());
                intent.putExtra("address",temp.getAddress());
                intent.putExtra("email",temp.getEmail());
                intent.putExtra("phone",temp.getPhone());
                intent.putExtra("position",temp.getId());
                startActivityForResult(intent,200);
                return true;
            }
        });
        getDatabaseContent();
    }

    private boolean getDatabaseContent() {
        Cursor c = resolver.query(Contact.CONTENT_URI, null, null, null, null);
        if(c.getCount() > 0) {
            c.moveToFirst();
            while(c.moveToNext()) {
                Contact temp = new Contact();
                temp.setFirstName(c.getString(c.getColumnIndex(Contact.FIRST_NAME)));
                temp.setLastName(c.getString(c.getColumnIndex(Contact.LAST_NAME)));
                temp.setTitle(c.getString(c.getColumnIndex(Contact.TITLE)));
                temp.setAddress(c.getString(c.getColumnIndex(Contact.ADDRESS)));
                temp.setEmail(c.getString(c.getColumnIndex(Contact.EMAIL)));
                temp.setPhone(c.getString(c.getColumnIndex(Contact.PHONE)));
                temp.setId(c.getInt(c.getColumnIndex(Contact._ID)));
                adapter.add(temp);
            }
            adapter.notifyDataSetChanged();
        }
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 100) {
            if(resultCode == RESULT_OK) {
                ContentValues v = new ContentValues();
                v.put(Contact.FIRST_NAME, data.getStringExtra("firstName"));
                v.put(Contact.LAST_NAME, data.getStringExtra("lastName"));
                v.put(Contact.TITLE, data.getStringExtra("title"));
                v.put(Contact.ADDRESS, data.getStringExtra("address"));
                v.put(Contact.EMAIL, data.getStringExtra("email"));
                v.put(Contact.PHONE, data.getStringExtra("phone"));
                resolver.insert(Contact.CONTENT_URI, v);
                adapter.clear();
                getDatabaseContent();
            }
        }
        if(requestCode == 200) {
            if(resultCode == RESULT_OK) {
                int id = data.getIntExtra("position", -1);
                if (id > -1) {
                    String where = "_id=?";
                    String[] args = new String[]{""+id};
                    int count = resolver.delete(Contact.CONTENT_URI, where, args);
                    if(count > 0){
                        adapter.clear();
                        getDatabaseContent();
                    }
                }
            }
        }
    }

    private class ContactCardAdapter extends ArrayAdapter<Contact> {

       public ContactCardAdapter(@NonNull Context context, int resource) {
           super(context, resource);
       }

       public ContactCardAdapter(@NonNull Context context, int resource, int textViewResourceId) {
           super(context, resource, textViewResourceId);
       }

       public ContactCardAdapter(@NonNull Context context, int resource, @NonNull Contact[] objects) {
           super(context, resource, objects);
       }

       public ContactCardAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Contact[] objects) {
           super(context, resource, textViewResourceId, objects);
       }

       public ContactCardAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
           super(context, resource, objects);
       }

       public ContactCardAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Contact> objects) {
           super(context, resource, textViewResourceId, objects);
       }
       public View getView(int pos, View convertView, ViewGroup parent) {
           if(convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.listview_row, null);
           }
           TextView firstName = convertView.findViewById(R.id.firstNamerow);
           TextView lastName = convertView.findViewById(R.id.lastNamerow);
           TextView title = convertView.findViewById(R.id.titlerow);
           Contact temp = adapter.getItem(pos);
           firstName.setText(temp.getFirstName());
           lastName.setText(temp.getLastName());
           title.setText(temp.getTitle());
           return convertView;
       }
   }
}
