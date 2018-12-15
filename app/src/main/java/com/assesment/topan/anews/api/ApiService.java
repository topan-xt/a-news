package com.assesment.topan.anews.api;

import com.assesment.topan.anews.model.ArticleModel;
import com.assesment.topan.anews.model.SourceNewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 24, 2018.                    *
 *************************************************/
public interface ApiService {
    @GET("sources")
    Call<SourceNewsModel> getSourcesNews(@Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<ArticleModel> getArticles(@Query("sources") String sourcesId, @Query("apiKey") String
            apiKey);

    @GET("everything")
    Call<ArticleModel> doSearch(@Query("q") String query, @Query("sources") String sourcesId,
                                @Query("apiKey") String apiKey);
}
