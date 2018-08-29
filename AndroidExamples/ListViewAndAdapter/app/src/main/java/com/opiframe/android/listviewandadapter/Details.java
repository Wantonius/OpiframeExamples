package com.opiframe.android.listviewandadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Details extends AppCompatActivity {

    private Button saveButton;
    private EditText firstName,lastName,title,address,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        saveButton = findViewById(R.id.saveButton);
        firstName = findViewById(R.id.firstnameEdit);
        lastName = findViewById(R.id.lastnameEdit);
        title = findViewById(R.id.titleEdit);
        address = findViewById(R.id.addressEdit);
        email = findViewById(R.id.emailEdit);
        phone = findViewById(R.id.phoneEdit);
        setResult(RESULT_CANCELED);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra("firstName", firstName.getText().toString());
                data.putExtra("lastName",lastName.getText().toString());
                data.putExtra("title", title.getText().toString());
                data.putExtra("address",address.getText().toString());
                data.putExtra("email", email.getText().toString());
                data.putExtra("phone",phone.getText().toString());
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}
