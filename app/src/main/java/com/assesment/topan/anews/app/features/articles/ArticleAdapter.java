package com.assesment.topan.anews.app.features.articles;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.assesment.topan.anews.R;
import com.assesment.topan.anews.app.features.articles.readarticle.ReadArticleActivity;
import com.assesment.topan.anews.model.ArticleModel;
import com.assesment.topan.anews.util.StringUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 25, 2018.                    *
 *************************************************/
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private List<ArticleModel.Articles> articlesList;
    private int                         rowLayout;
    private Context                     context;

    public ArticleAdapter(List<ArticleModel.Articles> articlesList, int rowLayout, Context
            context) {
        this.articlesList = articlesList;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup,
                false);
        return new ArticleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.textArticleTitle.setText(articlesList.get(i).getTitle());
        viewHolder.textArticleAuthor.setText(articlesList.get(i).getAuthor() + " on " +
                StringUtils.tailTrim(articlesList.get(i).getPublishedDate(), 10));

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.img_loading);
        if (articlesList.get(i).getImage() == null) {
            Glide.with(context).load(R.drawable.img_no_photo).into(viewHolder.imageArticle);
        } else {
            Glide.with(context)
                    .applyDefaultRequestOptions(requestOptions)
                    .load(articlesList.get(i).getImage())
                    .into(viewHolder.imageArticle);
        }


        viewHolder.cardArticle.setOnClickListener(view -> {
            Intent toReadArticle = new Intent(context, ReadArticleActivity.class);
            toReadArticle.putExtra("URL", articlesList.get(i).getUrl());
            toReadArticle.putExtra("TITLE", articlesList.get(i).getTitle());
            context.startActivity(toReadArticle);
        });
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_article)
        ImageView    imageArticle;
        @BindView(R.id.tv_article_title)
        TextView     textArticleTitle;
        @BindView(R.id.tv_article_author)
        TextView     textArticleAuthor;
        @BindView(R.id.card_article)
        LinearLayout cardArticle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
