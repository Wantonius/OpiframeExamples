package com.opiframe.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Button helloButton;
    private TextView helloText;
    private EditText helloedit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloButton = (Button)findViewById(R.id.hellobutton);
        helloText = (TextView)findViewById(R.id.hellotext);
        helloedit = (EditText)findViewById(R.id.helloEdit);
        helloButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.hellobutton) {
            String temp = helloedit.getText().toString();
            Intent intent = new Intent(this,HelloActivity.class);
            intent.putExtra("message",temp);
            startActivityForResult(intent,100);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this,"Message Sent",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
