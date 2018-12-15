package com.assesment.topan.anews.app.base;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 24, 2018.                    *
 *************************************************/
public interface BaseView {
    void showProgressDialog();

    void dismissProgressDialog();

    void showToast(String message);
}
