package com.opiframe.android.businesscards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BusinessCardList extends AppCompatActivity {

    private Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_card_list);
        addButton = (Button)findViewById(R.id.addbutton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BusinessCardList.this,AddNewCard.class);
                startActivityForResult(i,100);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==100){
            if(resultCode==RESULT_OK) {
                String temp = "Data from Intent:"+data.getStringExtra("title")+" "
                        +data.getStringExtra("firstname")+" "
                        +data.getStringExtra("lastname")+","
                        +data.getStringExtra("phone")+","
                        +data.getStringExtra("company");
                Toast.makeText(this,temp, Toast.LENGTH_LONG).show();
            }
        }
    }
}
