package com.assesment.topan.anews.app.features.articles.search;

import com.assesment.topan.anews.BuildConfig;
import com.assesment.topan.anews.app.base.BasePresenter;
import com.assesment.topan.anews.model.ArticleModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 26, 2018.                    *
 *************************************************/
public class SearchPresenter extends BasePresenter<SearchView> {

    void doSearch(String query, String sourcesID) {
        getView().showProgressDialog();
        apiService.doSearch(query, sourcesID, BuildConfig.API_KEY).enqueue(
                new Callback<ArticleModel>() {
                    @Override
                    public void onResponse(Call<ArticleModel> call, Response<ArticleModel>
                            response) {
                        if (response.isSuccessful()) {
                            if (response.body().getStatus().equals("ok")) {
                                List<ArticleModel.Articles> articles = response.body()
                                        .getArticles();
                                getView().setSubtitleToolbar(response.body().getTotalResults());
                                getView().setAdapter(articles);
                                getView().dismissProgressDialog();
                                if (response.body().getTotalResults().equals("0")) {
                                    getView().showToast("Sorry there is no article related with " +
                                            "your keyword");
                                }
                            }

                        } else
                            getView().showToast("Failed to receive data");
                    }

                    @Override
                    public void onFailure(Call<ArticleModel> call, Throwable t) {
                        getView().dismissProgressDialog();
                        getView().showToast(t.getMessage());
                    }
                }
        );
    }
}
