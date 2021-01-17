package com.example.muse_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.muse_android.R;
import com.example.muse_android.objects.CategoryArticle;
import com.example.muse_android.requests.fetchCategoryData;

import java.util.ArrayList;

public class CategoryCarouselAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<CategoryArticle> articles;
    Context c;

    public CategoryCarouselAdapter (Context c, ArrayList<CategoryArticle> articles) {
        this.c = c;
        this.articles = articles;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView article_image;
        TextView article_text;

        public ViewHolder(@NonNull View view) {
            super(view);
            article_image = (ImageView) view.findViewById(R.id.carouselImage);
            article_text = (TextView) view.findViewById(R.id.carouselText);
        }

        public ImageView getArticleImage() {
            return article_image;
        }

        public TextView getArticleText() {
            return article_text;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_carousel, parent, false);
        return new CategoryCarouselAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CategoryCarouselAdapter.ViewHolder viewHolder = (CategoryCarouselAdapter.ViewHolder) holder;

        CategoryArticle a = articles.get(position);
        String text = a.getTitle();
        String imageURL = a.getImage();

        viewHolder.article_text.setText(text);
        Glide.with(c).load(imageURL).into(viewHolder.article_image);
        viewHolder.article_image.setTag(a.getId());
        viewHolder.article_text.setTag(a.getId());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

}
