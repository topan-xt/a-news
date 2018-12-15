package com.assesment.topan.anews.app.features.articles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.assesment.topan.anews.R;
import com.assesment.topan.anews.app.base.BaseActivity;
import com.assesment.topan.anews.app.features.articles.search.SearchActivity;
import com.assesment.topan.anews.model.ArticleModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 24, 2018.                    *
 *************************************************/
public class ArticlesActivity extends BaseActivity implements ArticlesView {
    @BindView(R.id.rv_articles)
    RecyclerView recyclerView;
    private ArticlesPresenter presenter;
    private String            sourcesId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        initToolbar(getIntent().getStringExtra("NAME"), true);
        ButterKnife.bind(this);

        sourcesId = getIntent().getStringExtra("SOURCES_ID");

        presenter = new ArticlesPresenter();
        presenter.setView(this);
        presenter.getArticles(sourcesId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem                  item       = menu.findItem(R.id.menu_seach);
        android.widget.SearchView searchView = (android.widget.SearchView) item.getActionView();
        searchView.setQueryHint("Find Article");
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent doSearch = new Intent(ArticlesActivity.this, SearchActivity.class);
                doSearch.putExtra("QUERY", query);
                doSearch.putExtra("SOURCES_ID", sourcesId);

                startActivity(doSearch);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //showToast(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void setAdapter(List<ArticleModel.Articles> articlesList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ArticleAdapter(articlesList, R.layout.row_articles, this));
    }
}
