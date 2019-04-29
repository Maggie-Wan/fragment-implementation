package com.example.student.lab0302;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CountFragment teamA;
    CountFragment teamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamA= (CountFragment)getSupportFragmentManager().findFragmentById(R.id.teamA);
        teamB= (CountFragment)getSupportFragmentManager().findFragmentById(R.id.teamB);
    }


    @Override
    //右鍵=>generate=>override method=>onStart()
    //onStart() makes the fragment visible to the user (based on its containing activity being started).
    //If you override this method you must call through to the superclass implementation.
    protected void onStart() {
        super.onStart();
        //不能放在onCreate中，因為mainactivity在oncreate的時候fragment的view還沒產生
        //onCreate是在做設定開啟的畫面
        teamA.setName("黃蜂");
        teamB.setName("火箭");
        teamA.setTeamLogo(R.drawable.hornets);
        teamB.setTeamLogo(R.drawable.rockets);
    }


    public void clear(View v) {
        teamA.reset();
        teamB.reset();

    }

}

