package com.assesment.topan.anews.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 25, 2018.                    *
 *************************************************/
public class ArticleModel {
    @SerializedName("status")
    String         status;
    @SerializedName("articles")
    List<Articles> articles;
    @SerializedName("totalResults")
    String         totalResults;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public String toString() {
        return "ArticleModel{" +
                "status='" + status + '\'' +
                ", articles=" + articles +
                ", totalResults='" + totalResults + '\'' +
                '}';
    }

    public class Articles {
        @SerializedName("author")
        String author;
        @SerializedName("title")
        String title;
        @SerializedName("description")
        String description;
        @SerializedName("url")
        String url;
        @SerializedName("urlToImage")
        String image;
        @SerializedName("publishedAt")
        String publishedDate;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPublishedDate() {
            return publishedDate;
        }

        public void setPublishedDate(String publishedDate) {
            this.publishedDate = publishedDate;
        }

        @Override
        public String toString() {
            return "Articles{" +
                    "author='" + author + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", url='" + url + '\'' +
                    ", image='" + image + '\'' +
                    ", publishedDate='" + publishedDate + '\'' +
                    '}';
        }
    }
}
