package com.assesment.topan.anews.app.features.sources;

import com.assesment.topan.anews.BuildConfig;
import com.assesment.topan.anews.app.base.BasePresenter;
import com.assesment.topan.anews.model.SourceNewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 24, 2018.                    *
 *************************************************/
public class SourcesPresenter extends BasePresenter<SourcesView> {
    void getSourcesNews(String category) {
        getView().showProgressDialog();
        apiService.getSourcesNews(BuildConfig.API_KEY).enqueue(new Callback<SourceNewsModel>() {
            @Override
            public void onResponse(Call<SourceNewsModel> call, Response<SourceNewsModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("ok")) {
                        List<SourceNewsModel.Sources> sourcesList = response.body().getSources();
                        sourcesList.removeIf(c -> !c.getCategory().equals(category));
                        getView().setAdapter(sourcesList);
                        getView().dismissProgressDialog();
                    }

                } else
                    getView().showToast("Failed to receive data");
            }

            @Override
            public void onFailure(Call<SourceNewsModel> call, Throwable t) {
                getView().dismissProgressDialog();
                getView().showToast(t.getMessage());
            }
        });
    }


}
