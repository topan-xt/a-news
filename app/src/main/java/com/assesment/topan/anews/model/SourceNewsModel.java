package com.assesment.topan.anews.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 24, 2018.                    *
 *************************************************/
public class SourceNewsModel {
    @SerializedName("status")
    String        status;
    @SerializedName("sources")
    List<Sources> sources;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Sources> getSources() {
        return sources;
    }

    public void setSources(List<Sources> sources) {
        this.sources = sources;
    }

    @Override
    public String toString() {
        return "SourceNewsModel{" +
                "status='" + status + '\'' +
                ", sources=" + sources +
                '}';
    }

    public class Sources {
        @SerializedName("id")
        String id;
        @SerializedName("name")
        String name;
        @SerializedName("description")
        String description;
        @SerializedName("category")
        String category;
        @SerializedName("language")
        String language;
        @SerializedName("country")
        String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        @Override
        public String toString() {
            return "Sources{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", category='" + category + '\'' +
                    ", language='" + language + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }
}
