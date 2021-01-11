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

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<CategoryArticle> articles;
    Context c;

    public CategoryAdapter (Context c, ArrayList<CategoryArticle> articles) {
        this.c = c;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_preview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryArticle a = articles.get(position);
        String text = a.getTitle();
        String imageURL = a.getImage();
        holder.article_text.setText(text);
        Glide.with(c).load(imageURL).into(holder.article_image);
        holder.article_image.setTag(a.getId());
        holder.article_text.setTag(a.getId());

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView article_image;
        TextView article_text;

        public ViewHolder(@NonNull View view) {
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

}