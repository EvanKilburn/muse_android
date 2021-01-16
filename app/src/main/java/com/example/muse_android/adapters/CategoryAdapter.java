package com.example.muse_android.adapters;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.muse_android.CategoriesActivity;
import com.example.muse_android.R;
import com.example.muse_android.objects.CategoryArticle;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private CategoriesActivity categoriesActivity;
    public ArrayList<CategoryArticle> articles;
    public ArrayList<CategoryArticle> carouselArticles;
    private String [] titles;
    Context c;
    public ViewHolderCarousel viewHolderCarousel;

    public CategoryAdapter (CategoriesActivity categoriesActivity, ArrayList<CategoryArticle> articles,
                            ArrayList<CategoryArticle> carouselArticles, String [] titles, Context c) {
        this.categoriesActivity = categoriesActivity;
        this.articles = articles;
        this.carouselArticles = carouselArticles;
        this.titles = titles;
        this.c = c;
    }

    public static class ViewHolderTitle extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolderTitle(@NonNull View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }

        public TextView getArticleText() {
            return title;
        }

    }

    public static class ViewHolderCarousel extends RecyclerView.ViewHolder {
        public RecyclerView.Adapter carouselAdapter;
        public LinearLayoutManager carouselLayoutManager;
        public RecyclerView carouselRecyclerView;

        public ViewHolderCarousel(@NonNull View view, ArrayList<CategoryArticle> articles) {
            super(view);
            carouselRecyclerView = view.findViewById(R.id.carouselView);
            carouselLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
            carouselAdapter = new CategoryCarouselAdapter(view.getContext(), articles);
        }

        public RecyclerView.Adapter getCarouselAdapter() {
            return carouselAdapter;
        }

        public RecyclerView.LayoutManager getCarouselLayoutManager() {
            return carouselLayoutManager;
        }

        public RecyclerView getCarouselRecyclerView() {
            return carouselRecyclerView;
        }
    }

    public static class ViewHolderCategories extends RecyclerView.ViewHolder {
        ImageView article_image;
        TextView article_text;

        public ViewHolderCategories(@NonNull View view) {
            super(view);
            article_image = (ImageView) view.findViewById(R.id.imageView);
            article_text = (TextView) view.findViewById(R.id.textView);
        }

        public ImageView getArticleImage() {
            return article_image;
        }

        public TextView getArticleText() {
            return article_text;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0 || viewType == 2) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_title, parent, false);
            return new ViewHolderTitle(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_carousel_overview, parent, false);
            viewHolderCarousel = new ViewHolderCarousel(view, this.carouselArticles);
            return viewHolderCarousel;
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_preview, parent, false);
            return new ViewHolderCategories(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == 0) {

            ViewHolderTitle viewHolderTitle = (ViewHolderTitle) holder;
            viewHolderTitle.title.setText(titles[0]);

        } else if (holder.getItemViewType() == 1) {

            ViewHolderCarousel viewHolderCarousel = (ViewHolderCarousel) holder;
            ViewCompat.setNestedScrollingEnabled(viewHolderCarousel.carouselRecyclerView, false);
            viewHolderCarousel.carouselRecyclerView.setLayoutManager(viewHolderCarousel.carouselLayoutManager);
            viewHolderCarousel.carouselRecyclerView.setAdapter(viewHolderCarousel.carouselAdapter);

        } else if (holder.getItemViewType() == 2) {

            ViewHolderTitle viewHolderTitle = (ViewHolderTitle) holder;
            viewHolderTitle.title.setText(titles[1]);

        } else {

            ViewHolderCategories viewHolderCategories = (ViewHolderCategories) holder;

            CategoryArticle a = articles.get(position - 3);
            String text = a.getTitle();
            String imageURL = a.getImage();

            viewHolderCategories.article_text.setText(text);
            Glide.with(c).load(imageURL).into(viewHolderCategories.article_image);
            viewHolderCategories.article_image.setTag(a.getId());
            viewHolderCategories.article_text.setTag(a.getId());

        }
    }

    @Override
    public int getItemCount() {
        return articles.size() + 3;
    }

    public CategoriesActivity getCategoriesActivity() {
        return categoriesActivity;
    }
}