package com.opiframe.android.businesscards;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowSingleCard extends AppCompatActivity {

    private TextView titleText;
    private TextView nameText;
    private TextView companyText;
    private TextView phoneText;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_single_card);
        titleText = (TextView)findViewById(R.id.titlesinglecard);
        nameText = (TextView)findViewById(R.id.namesinglecard);
        companyText = (TextView)findViewById(R.id.companysinglecard);
        phoneText = (TextView)findViewById(R.id.phonesinglecard);
        Intent i = getIntent();
        setResult(RESULT_CANCELED);
        position = i.getIntExtra("position",-1);
        titleText.setText(i.getStringExtra("title"));
        String temp = String.format("%s %s", i.getStringExtra("firstname"), i.getStringExtra("lastname"));
        nameText.setText(temp);
        companyText.setText(i.getStringExtra("company"));
        phoneText.setText(i.getStringExtra("phone"));
        View v = findViewById(R.id.singlecardlayout);
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ShowSingleCard.this);
                dialog.setMessage("Are you sure you want to delete this card?");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.putExtra("position", position);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
                return true;
            }
        });
    }
}
