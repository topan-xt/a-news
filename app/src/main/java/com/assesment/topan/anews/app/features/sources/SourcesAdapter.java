package com.assesment.topan.anews.app.features.sources;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.assesment.topan.anews.R;
import com.assesment.topan.anews.app.features.articles.ArticlesActivity;
import com.assesment.topan.anews.model.SourceNewsModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 24, 2018.                    *
 *************************************************/
public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.ViewHolder> {
    private List<SourceNewsModel.Sources> sourcesList;
    private int                           rowLayout;
    private Context                       context;

    public SourcesAdapter(List<SourceNewsModel.Sources> sourcesList, int rowLayout, Context
            context) {
        this.sourcesList = sourcesList;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.textNewsTitle.setText(sourcesList.get(i).getName());
        viewHolder.textNewsDescription.setText(sourcesList.get(i).getDescription());
        viewHolder.textNewsLanguage.setText(sourcesList.get(i).getLanguage());
        viewHolder.textNewsCountry.setText(sourcesList.get(i).getCountry());

        viewHolder.cardViewResorces.setOnClickListener(view -> {
            Intent toArticleActivity = new Intent(context, ArticlesActivity.class);
            toArticleActivity.putExtra("SOURCES_ID", sourcesList.get(i).getId());
            toArticleActivity.putExtra("NAME", sourcesList.get(i).getName());
            context.startActivity(toArticleActivity);
        });
    }

    @Override
    public int getItemCount() {
        return sourcesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_news_title)
        TextView     textNewsTitle;
        @BindView(R.id.tv_news_description)
        TextView     textNewsDescription;
        @BindView(R.id.tv_news_language)
        TextView     textNewsLanguage;
        @BindView(R.id.tv_news_country)
        TextView     textNewsCountry;
        @BindView(R.id.card_sources)
        LinearLayout cardViewResorces;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
