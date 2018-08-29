package com.opiframe.android.listviewandadapter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContactCard extends AppCompatActivity {

    private TextView title,name,address,email,phone;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_card);
        setResult(RESULT_CANCELED);
        Intent data = getIntent();
        position = data.getIntExtra("position",-1);
        name = findViewById(R.id.namecontactcard);
        title = findViewById(R.id.titlecontactcard);
        address = findViewById(R.id.addresscontactcard);
        email = findViewById(R.id.emailcontactcard);
        phone = findViewById(R.id.phonecontactcard);
        name.setText(data.getStringExtra("firstName")+" "+data.getStringExtra("lastName"));
        title.setText(data.getStringExtra("title"));
        address.setText(data.getStringExtra("address"));
        email.setText(data.getStringExtra("email"));
        phone.setText(data.getStringExtra("phone"));
        View v = findViewById(R.id.contactcardlayout);
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ContactCard.this);
                builder.setMessage("Are you sure you wish to remove this card?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.putExtra("position",position);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
                return true;
            }
        });
    }
}
