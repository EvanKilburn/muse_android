package com.example.muse_android.objects;

import com.example.muse_android.adapters.CategoryAdapter;

public class CategoryArticle {

    private String id;
    private String title;
    private String image;
    private String author;
    private String categoryName;

    public CategoryArticle() {
        this.id = null;
        this.title = null;
        this.image = null;
        this.author = null;
        this.categoryName = null;
    }

    public CategoryArticle(String id, String title, String image, String author, String categoryName) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.author = author;
        this.categoryName = categoryName;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
