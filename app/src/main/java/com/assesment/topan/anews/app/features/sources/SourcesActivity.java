package com.assesment.topan.anews.app.features.sources;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.assesment.topan.anews.R;
import com.assesment.topan.anews.app.base.BaseActivity;
import com.assesment.topan.anews.model.SourceNewsModel;
import com.assesment.topan.anews.util.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SourcesActivity extends BaseActivity implements SourcesView {
    @BindView(R.id.tab_layout_sources)
    TabLayout    tabLayout;
    @BindView(R.id.rv_sources)
    RecyclerView recyclerViewSources;
    private SourcesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sources);
        ButterKnife.bind(this);

        initTabLayout();
        presenter = new SourcesPresenter();
        presenter.setView(this);
        presenter.getSourcesNews(Constant.Category.GENERAL.toLowerCase());
    }

    void initTabLayout() {
        initToolbar(getString(R.string.app_name), getString(R.string.sub_title_name), false);

        tabLayout.addTab(tabLayout.newTab().setText(Constant.Category.GENERAL));
        tabLayout.addTab(tabLayout.newTab().setText(Constant.Category.BUSINESS));
        tabLayout.addTab(tabLayout.newTab().setText(Constant.Category.TECHNOLOGY));
        tabLayout.addTab(tabLayout.newTab().setText(Constant.Category.SPORTS));
        tabLayout.addTab(tabLayout.newTab().setText(Constant.Category.ENTERTAINTMENT));
        tabLayout.addTab(tabLayout.newTab().setText(Constant.Category.SCIENCE));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    presenter.getSourcesNews(Constant.Category.GENERAL.toLowerCase());
                } else if (tab.getPosition() == 1) {
                    presenter.getSourcesNews(Constant.Category.BUSINESS.toLowerCase());
                } else if (tab.getPosition() == 2) {
                    presenter.getSourcesNews(Constant.Category.TECHNOLOGY.toLowerCase());
                } else if (tab.getPosition() == 3) {
                    presenter.getSourcesNews(Constant.Category.SPORTS.toLowerCase());
                } else if (tab.getPosition() == 4) {
                    presenter.getSourcesNews(Constant.Category.ENTERTAINTMENT.toLowerCase());
                } else if (tab.getPosition() == 5) {
                    presenter.getSourcesNews(Constant.Category.SCIENCE.toLowerCase());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    presenter.getSourcesNews(Constant.Category.GENERAL.toLowerCase());
                } else if (tab.getPosition() == 1) {
                    presenter.getSourcesNews(Constant.Category.BUSINESS.toLowerCase());
                } else if (tab.getPosition() == 2) {
                    presenter.getSourcesNews(Constant.Category.TECHNOLOGY.toLowerCase());
                } else if (tab.getPosition() == 3) {
                    presenter.getSourcesNews(Constant.Category.SPORTS.toLowerCase());
                } else if (tab.getPosition() == 4) {
                    presenter.getSourcesNews(Constant.Category.ENTERTAINTMENT.toLowerCase());
                } else if (tab.getPosition() == 5) {
                    presenter.getSourcesNews(Constant.Category.SCIENCE.toLowerCase());
                }
            }
        });
    }


    @Override
    public void setAdapter(List<SourceNewsModel.Sources> sourcesList) {
        recyclerViewSources.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSources.setAdapter(new SourcesAdapter(sourcesList, R.layout.row_sources, this));
    }
}

