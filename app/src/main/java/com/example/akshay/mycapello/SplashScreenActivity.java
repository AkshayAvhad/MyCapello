package com.example.akshay.mycapello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Akshay on 31-12-2015.
 */
public class SplashScreenActivity extends Activity {

    private static int Splash_timeout = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this,HomeScreenActivity.class);
                startActivity(i);

                finish();
            }
        },Splash_timeout);
    }
}
