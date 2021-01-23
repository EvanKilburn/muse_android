package com.example.muse_android.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.muse_android.R;
import com.example.muse_android.objects.Article;

import java.util.List;

public class FullArticleAdapter extends RecyclerView.Adapter<FullArticleAdapter.ArticleViewHolder> {

    private String page = "n";
    private LayoutInflater mInflater;
    private List<Article> mData;
    Context c;

    public FullArticleAdapter(Context c, List<Article> data){
        this.mInflater = LayoutInflater.from(c);
        this.mData = data;
        this.c = c;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.article_display, parent, false);
        return new ArticleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article a = mData.get(position);
        String title = a.getTitle();
        String content = a.getContent();
        //String author = a.getAuthor();
        //String date = a.getDate();
        String imageURL = a.getImage();
        holder.article_title.setText(title);
        Html.ImageGetter ig = new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                Drawable d = c.getResources().getDrawable(R.drawable.ic_launcher);
                d.setBounds(0,0,d.getIntrinsicWidth(),d.getIntrinsicHeight());
                return d;
            }
        };
        Spanned spanned = Html.fromHtml(content, ig, null);
//        holder.article_content.setText("\n"+ Html.fromHtml(content, ig, null));
        holder.article_content.setText(spanned);

        //holder.article_date.setText(date);
        //holder.article_author.setText(author);
        Glide.with(c).load(imageURL).into(holder.article_image);
    }



    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder{
        ImageView article_image;
        TextView article_content;
        TextView article_author;
        TextView article_date;
        TextView article_title;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            article_image = itemView.findViewById(R.id.imageView);
            article_content = itemView.findViewById(R.id.textView4);
//            article_author = itemView.findViewById(R.id.textView2);
//            article_date = itemView.findViewById(R.id.textView3);
            article_title = itemView.findViewById(R.id.textView);
        }
    }

}
