package com.assesment.topan.anews.app.base;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.assesment.topan.anews.R;

import dmax.dialog.SpotsDialog;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 24, 2018.                    *
 *************************************************/
public class BaseActivity extends AppCompatActivity implements BaseView {
    private AlertDialog progressDialog;

    public void initToolbar(String title, String subTitle, boolean isDisplayShowHomeEnabled) {
        getSupportActionBar().setElevation(0);

        if (isDisplayShowHomeEnabled == false) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setSubtitle(subTitle);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setLogo(R.drawable.ic_logo);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        } else if (isDisplayShowHomeEnabled == true) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setSubtitle(subTitle);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void initToolbar(String title, boolean isDisplayShowHomeEnabled) {
        getSupportActionBar().setElevation(0);

        if (isDisplayShowHomeEnabled == false) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setLogo(R.drawable.ic_logo);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        } else if (isDisplayShowHomeEnabled == true) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new SpotsDialog.Builder()
                    .setContext(this)
                    .setTheme(R.style.ProgressDialogStyle)
                    .build();

            progressDialog.show();
        }
    }


    @Override
    public void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }
}
