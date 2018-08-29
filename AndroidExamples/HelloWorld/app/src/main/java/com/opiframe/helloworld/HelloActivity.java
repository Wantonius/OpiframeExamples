package com.opiframe.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    private TextView tv;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        setResult(Activity.RESULT_CANCELED);
        Intent intent = getIntent();
        tv = (TextView)findViewById(R.id.message);
        backButton = (Button)findViewById(R.id.backbutton);
        String temp = intent.getStringExtra("message");
        tv.setText(temp);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }
}
