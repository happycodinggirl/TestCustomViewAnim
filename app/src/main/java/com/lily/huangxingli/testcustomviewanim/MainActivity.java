package com.lily.huangxingli.testcustomviewanim;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;



public class MainActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MoodChangeIndicator moodChangeIndicator= (MoodChangeIndicator) findViewById(R.id.moodPan);
        moodChangeIndicator.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                moodChangeIndicator.toggle();
            }
        });

    }
}
