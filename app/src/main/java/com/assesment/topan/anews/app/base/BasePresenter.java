package com.assesment.topan.anews.app.base;

import android.support.annotation.CallSuper;

import com.assesment.topan.anews.api.ApiClient;
import com.assesment.topan.anews.api.ApiService;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 24, 2018.                    *
 *************************************************/
public class BasePresenter<V extends BaseView> {
    public  ApiService apiService = ApiClient.getClient().create(ApiService.class);
    private V          view;

    protected V getView() {
        return view;
    }

    @CallSuper
    public void setView(V view) {
        this.view = view;
    }
}
