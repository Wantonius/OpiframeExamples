package com.opiframe.android.businesscards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewCard extends AppCompatActivity {

    private static final String TAG="AddNewCard";
    private EditText firstName;
    private EditText lastName;
    private EditText phone;
    private EditText title;
    private EditText company;
    private Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_add_new_card);
        firstName = (EditText)findViewById(R.id.firstnameedit);
        lastName= (EditText)findViewById(R.id.lastnameedit);
        phone = (EditText)findViewById(R.id.phoneedit);
        title = (EditText)findViewById(R.id.titleedit);
        company = (EditText)findViewById(R.id.companyedit);
        saveButton = (Button)findViewById(R.id.savebutton);
        setResult(RESULT_CANCELED);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = getIntent();
                data.putExtra("firstname",firstName.getText().toString());
                data.putExtra("lastname",lastName.getText().toString());
                data.putExtra("phone",phone.getText().toString());
                data.putExtra("title",title.getText().toString());
                data.putExtra("company",company.getText().toString());
                setResult(RESULT_OK,data);
                finish();
            }
        });
    }
}
