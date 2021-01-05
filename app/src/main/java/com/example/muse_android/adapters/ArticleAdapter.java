package com.example.muse_android.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.muse_android.MainActivity;
import com.example.muse_android.R;
import com.example.muse_android.objects.Article;

import java.io.InputStream;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private String page = "n";
    private LayoutInflater mInflater;
    private List<Article> mData;
    Context c;

    public ArticleAdapter(Context c, List<Article> data){
        this.mInflater = LayoutInflater.from(c);
        this.mData = data;
        this.c = c;
//        page = this.page;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.article_preview, parent, false);

//        if (page.equals("n")){
//            v = mInflater.inflate(R.layout.article_preview, parent, false);
//        } else{
////            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_preview, parent, false);
//            v = mInflater.inflate(R.layout.article_preview, parent, false);
//        }
        //ArticleViewHolder avh = new ArticleViewHolder(v);
        return new ArticleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
//        if (page.equals("n")){
//            Article current = MainActivity.newArticles.get(position);
//            //holder.article_image.setImageBitmap(getImage(current.getImage()));
//            holder.article_text.setText(current.getTitle());
//        } else{
//            Article current = MainActivity.newArticles.get(position);
//            //holder.article_image.setImageBitmap(getImage(current.getImage()));
//            holder.article_text.setText(current.getTitle());
//        }
//        System.out.println("Done");
        Article a = mData.get(position);
        String text = a.getTitle();
        String imageURL = a.getImage();
        holder.article_text.setText(text);

//        ImageView temp;
        Glide.with(c).load(imageURL).into(holder.article_image);
//        holder.article_image.setImageDrawable(temp.getDrawable());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder{
        TextView article_text;
        ImageView article_image;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            article_text = itemView.findViewById(R.id.textView);
            article_image = itemView.findViewById(R.id.imageView);
        }
    }

//    protected Bitmap getArticleImage(String url) {
//        String urldisplay = url;
//        Bitmap mIcon11 = null;
//        try {
//            InputStream in = new java.net.URL(urldisplay).openStream();
//            mIcon11 = BitmapFactory.decodeStream(in);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return mIcon11;
//    }

}
