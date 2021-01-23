package com.example.muse_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.muse_android.adapters.ArticleAdapter;
import com.example.muse_android.adapters.FullArticleAdapter;
import com.example.muse_android.objects.AllCategory;
import com.example.muse_android.objects.Article;

import com.example.muse_android.objects.CategoryArticle;
import com.example.muse_android.requests.fetchArticleData;
import com.example.muse_android.requests.fetchCategoryData;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Article> newArticles = new ArrayList<>();
    public static RecyclerView mRecyclerView;
    public static RecyclerView.Adapter mAdapter;
    public static RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new AllCategory();

        final ProgressBar progressBar = findViewById(R.id.progressBar);
        final int maxProgress = 20000;
        final int progressIncrement = 10;

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    progressBar.setMax(maxProgress);
                    for(int i = 0; i < maxProgress; i+=progressIncrement) {
                        sleep(progressIncrement);
                        progressBar.setProgress(i);
                    }
                    while(AllCategory.allCategory == null || AllCategory.allCategory[AllCategory.allCategory.length - 1].size() == 0) {
                        sleep(progressIncrement);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent(MainActivity.this,
                            CategoriesActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();
//        loadNewArticles();
//        mRecyclerView = findViewById(R.id.recyclerView);
////        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        mAdapter = new ArticleAdapter(this, newArticles);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(mAdapter);
//
//    }

    private void articleSelected(Article selected) {
        List<Article> selectedArticle = new ArrayList<>();
        selectedArticle.add(selected);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new FullArticleAdapter(this, selectedArticle);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void loadNewArticles(){

//        try{
//            URL url = new URL("http://www.muse-magazine.com/wp-json/wp/v2/posts");
            fetchArticleData process = new fetchArticleData();
            process.execute();

//        } catch (MalformedURLException e){
//            e.printStackTrace();
//        }
//            toCategoriesPage(this.findViewById(R.id.mainLayout).getRootView());
    }
}
