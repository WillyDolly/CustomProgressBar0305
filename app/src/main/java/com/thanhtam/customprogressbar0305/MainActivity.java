package com.thanhtam.customprogressbar0305;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ProgressBar progressBar;
Button btnStart;
    int progress;
    CountDownTimer cdt;
    int timeInMiliSecond =10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        btnStart = (Button)findViewById(R.id.btnStart);
        progressBar.setMax(timeInMiliSecond);// max must >= 100

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = 0;
                startCountDown();
            }
        });
    }

    private void startCountDown(){
        cdt = new CountDownTimer(timeInMiliSecond,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progress = progress+1000;
                progressBar.setProgress(progress);
            }

            @Override
            public void onFinish() {//timeInMilliSecond include time for onFinish
                progressBar.setProgress(timeInMiliSecond);
                Toast.makeText(MainActivity.this,"done",Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
}
