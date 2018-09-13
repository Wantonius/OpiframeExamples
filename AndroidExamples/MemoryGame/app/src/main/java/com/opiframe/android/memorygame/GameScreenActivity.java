package com.opiframe.android.memorygame;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameScreenActivity extends AppCompatActivity implements View.OnClickListener{

    private boolean isShowing = false, gameLost = false;
    private int currentScore = 0, currentIndex = 0;
    private List<Integer> buttonList = new ArrayList<>();
    private Button first,second,third,fourth,fifth,sixth,seventh,eighth,ninth;
    private int delayValue = 200;
    private Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        first = findViewById(R.id.firstButton);
        second = findViewById(R.id.secondButton);
        third = findViewById(R.id.thirdButton);
        fourth = findViewById(R.id.fourthButton);
        fifth = findViewById(R.id.fifthButton);
        sixth = findViewById(R.id.sixthButton);
        seventh = findViewById(R.id.seventhButton);
        eighth = findViewById(R.id.eighthButton);
        ninth = findViewById(R.id.ninthButton);
        random = new Random();
        for(int i = 0; i<3; i++) {
            createNextNumber();
        }
        first.setOnClickListener(this);
        second.setOnClickListener(this);
        third.setOnClickListener(this);
        fourth.setOnClickListener(this);
        fifth.setOnClickListener(this);
        sixth.setOnClickListener(this);
        seventh.setOnClickListener(this);
        eighth.setOnClickListener(this);
        ninth.setOnClickListener(this);
        setResult(RESULT_CANCELED);
        GameLogic temp = new GameLogic();
        temp.execute(null,null,null);
    }

    private void createNextNumber() {
        int temp = random.nextInt(9)+1;
        buttonList.add(temp);
    }

    @Override
    public void onClick(View view) {
        Log.d("onClick","Button:"+view.getId());
        if(isShowing){
            return;
        }
        int currentButton;
        currentButton = buttonList.get(currentIndex);
        switch(view.getId()) {
            case R.id.firstButton:
                if(currentButton != 1) {
                    gameLost = true;
                }
                break;
            case R.id.secondButton:
                if(currentButton != 2) {
                    gameLost = true;
                }
                break;
            case R.id.thirdButton:
                if(currentButton != 3) {
                    gameLost = true;
                }
                break;
            case R.id.fourthButton:
                if(currentButton != 4) {
                    gameLost = true;
                }
                break;
            case R.id.fifthButton:
                if(currentButton != 5) {
                    gameLost = true;
                }
                break;
            case R.id.sixthButton:
                if(currentButton != 6) {
                    gameLost = true;
                }
                break;
            case R.id.seventhButton:
                if(currentButton != 7) {
                    gameLost = true;
                }
                break;
            case R.id.eighthButton:
                if(currentButton != 8) {
                    gameLost = true;
                }
                break;
            case R.id.ninthButton:
                if(currentButton != 9) {
                    gameLost = true;
                }
                break;
            default:
                break;
        }
        if(gameLost) {
            Toast.makeText(this, "Whee, you lost!!! Your score:"+currentScore, Toast.LENGTH_SHORT).show();
            Intent data = new Intent();
            data.putExtra("result",currentScore);
            finish();
        } else {
            if(currentIndex == buttonList.size()-1) {
                currentScore++;
                createNextNumber();
                currentIndex = 0;
                Toast.makeText(this, "Next round", Toast.LENGTH_SHORT).show();
                GameLogic temp = new GameLogic();
                temp.execute(null,null,null);
            } else {
                currentIndex++;
            }
        }
    }
    private class GameLogic extends AsyncTask<Void, Integer, Void> {

        private boolean isRed = false;
        @Override
        protected Void doInBackground(Void... voids) {
            Log.d("AsyncTask","doInBackGround");

            for(int i = 0; i < buttonList.size(); i++) {
                try {
                    Thread.sleep(delayValue);
                } catch (InterruptedException e) {
                    Log.e("AsyncTask", "Interrupted exception");
                    finish();
                }
                for(int j=0;j<2;j++) {

                    publishProgress(buttonList.get(i));
                    try {
                        Thread.sleep(delayValue);
                    } catch (InterruptedException e) {
                        Log.e("AsyncTask", "Interrupted exception");
                        finish();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.d("AsyncTask", "onProgressUpdate");
            super.onProgressUpdate(values);

            int buttonId = values[0];
                Log.d("AsyncTask", "ButtonID:" + buttonId + ", isRed:" + isRed);
                switch (buttonId) {
                    case 1:
                        if (isRed) {
                            Log.d("Asynctask","isRed!");
                            first.setBackgroundColor(getResources().getColor(R.color.gameGreen, null));
                        } else {
                            first.setBackgroundColor(getResources().getColor(R.color.gameRed, null));
                        }
                        break;
                    case 2:
                        if (isRed) {
                            Log.d("Asynctask","isRed!");
                            second.setBackgroundColor(getResources().getColor(R.color.gameGreen, null));
                        } else {
                            second.setBackgroundColor(getResources().getColor(R.color.gameRed, null));
                        }
                        break;
                    case 3:
                        if (isRed) {
                            Log.d("Asynctask","isRed!");
                            third.setBackgroundColor(getResources().getColor(R.color.gameGreen, null));
                        } else {
                            third.setBackgroundColor(getResources().getColor(R.color.gameRed, null));
                        }
                        break;
                    case 4:
                        if (isRed) {
                            Log.d("Asynctask","isRed!");
                            fourth.setBackgroundColor(getResources().getColor(R.color.gameGreen, null));
                        } else {
                            fourth.setBackgroundColor(getResources().getColor(R.color.gameRed, null));
                        }
                        break;
                    case 5:
                        if (isRed) {
                            Log.d("Asynctask","isRed!");
                            fifth.setBackgroundColor(getResources().getColor(R.color.gameGreen, null));
                        } else {
                            fifth.setBackgroundColor(getResources().getColor(R.color.gameRed, null));
                        }
                        break;
                    case 6:
                        if (isRed) {
                            Log.d("Asynctask","isRed!");
                            sixth.setBackgroundColor(getResources().getColor(R.color.gameGreen, null));
                        } else {
                            sixth.setBackgroundColor(getResources().getColor(R.color.gameRed, null));
                        }
                        break;
                    case 7:
                        if (isRed) {
                            Log.d("Asynctask","isRed!");
                            seventh.setBackgroundColor(getResources().getColor(R.color.gameGreen, null));
                        } else {
                            seventh.setBackgroundColor(getResources().getColor(R.color.gameRed, null));
                        }
                        break;
                    case 8:
                        if (isRed) {
                            Log.d("Asynctask","isRed!");
                            eighth.setBackgroundColor(getResources().getColor(R.color.gameGreen, null));
                        } else {
                            eighth.setBackgroundColor(getResources().getColor(R.color.gameRed, null));
                        }
                        break;
                    case 9:
                        if (isRed) {
                            Log.d("Asynctask","isRed!");
                            ninth.setBackgroundColor(getResources().getColor(R.color.gameGreen, null));
                        } else {
                            ninth.setBackgroundColor(getResources().getColor(R.color.gameRed, null));
                        }
                        break;
                    default:
                        break;
                }
            if(isRed) {
                    isRed=false;
            } else {
                    isRed=true;
            }

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("AsyncTask","onPreExecute");
            isShowing=true;
            Toast.makeText(GameScreenActivity.this,"Memorize this", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d("AsyncTask","onPostExecute");
            isShowing = false;
            Toast.makeText(GameScreenActivity.this, "Your turn", Toast.LENGTH_SHORT).show();
        }
    }
}
