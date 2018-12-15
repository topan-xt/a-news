package com.assesment.topan.anews.app.features.articles.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.assesment.topan.anews.R;
import com.assesment.topan.anews.app.base.BaseActivity;
import com.assesment.topan.anews.app.features.articles.ArticleAdapter;
import com.assesment.topan.anews.model.ArticleModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 26, 2018.                    *
 *************************************************/
public class SearchActivity extends BaseActivity implements SearchView {

    SearchPresenter presenter;
    @BindView(R.id.rv_search_articles)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);

        presenter = new SearchPresenter();
        presenter.setView(this);
        presenter.doSearch(getIntent().getStringExtra("QUERY"), getIntent().getStringExtra("SOURCES_ID"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setAdapter(List<ArticleModel.Articles> articlesList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ArticleAdapter(articlesList, R.layout.row_articles, this));
    }

    @Override
    public void setSubtitleToolbar(String subtitleToolbar) {
        initToolbar(getIntent().getStringExtra("QUERY"), "Found " + subtitleToolbar + " article(s)",
                true);
    }
}
