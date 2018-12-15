package com.assesment.topan.anews.app.features.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;

import com.assesment.topan.anews.R;
import com.assesment.topan.anews.app.base.BaseActivity;
import com.assesment.topan.anews.app.features.sources.SourcesActivity;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 24, 2018.                    *
 *************************************************/
public class SplashScreenActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();


        new CountDownTimer(1000, 2000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashScreenActivity.this, SourcesActivity.class));
                finish();
            }
        }.start();

    }
}
