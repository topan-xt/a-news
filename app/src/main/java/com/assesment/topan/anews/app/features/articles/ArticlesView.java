package com.assesment.topan.anews.app.features.articles;

import com.assesment.topan.anews.app.base.BaseView;
import com.assesment.topan.anews.model.ArticleModel;

import java.util.List;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 24, 2018.                    *
 *************************************************/
public interface ArticlesView extends BaseView {
    void setAdapter(List<ArticleModel.Articles> articlesList);
}
