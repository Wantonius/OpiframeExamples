package com.opiframe.android.listviewandadapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataList extends AppCompatActivity {

    private ContactCardAdapter adapter;
    private Button addButton;
    private ListView lw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        addButton = findViewById(R.id.addButton);
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

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 100) {
            if(resultCode == RESULT_OK) {
                Contact temp = new Contact();
                temp.setFirstName(data.getStringExtra("firstName"));
                temp.setLastName(data.getStringExtra("lastName"));
                temp.setTitle(data.getStringExtra("title"));
                temp.setAddress(data.getStringExtra("address"));
                temp.setEmail(data.getStringExtra("email"));
                temp.setPhone(data.getStringExtra("phone"));
                adapter.add(temp);
                adapter.notifyDataSetChanged();
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
