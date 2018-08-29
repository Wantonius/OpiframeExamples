package com.opiframe.android.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView message;
    private Button backButton;
    private String messageText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        setResult(RESULT_CANCELED);
        messageText = i.getStringExtra("name");
        message = (TextView)findViewById(R.id.message);
        backButton = findViewById(R.id.backButton);
        message.setText(""+i.getStringExtra("name")+" says hello");
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("message",messageText);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
