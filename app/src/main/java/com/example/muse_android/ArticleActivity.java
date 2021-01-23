package com.example.muse_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.muse_android.adapters.FullArticleAdapter;
import com.example.muse_android.objects.Article;
import com.example.muse_android.requests.helpers.LoadArticle;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends AppCompatActivity {

    public static RecyclerView mRecyclerView;
    public static RecyclerView.Adapter mAdapter;
    public static RecyclerView.LayoutManager mLayoutManager;
    public static List<Article> newArticles = new ArrayList<>();
    public static Article a;
    public String id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newArticles.clear();
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        load();
//        setDisplay();
        mRecyclerView = findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new FullArticleAdapter(this, newArticles);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    private  void load(){
//        TextView ttv = (TextView)findViewById(R.id.textView);
//        TextView ctv = (TextView)findViewById(R.id.textView4);
        LoadArticle process = new LoadArticle(id);;
        process.execute();

//        setDisplay();
    }
//
//    private void setDisplay(){
//
////        ImageView iv = (ImageView)findViewById(R.id.imageView);
////        Glide.with(this).load(a.getImage()).into(iv);
//        String title = a.getTitle();
//        String content = a.getContent();
//
//        ttv.setText(title);
//        ctv.setText(content);
//
//    }

}
