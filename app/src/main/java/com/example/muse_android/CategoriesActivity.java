package com.example.muse_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.muse_android.adapters.CategoryFragmentAdapter;
import com.example.muse_android.objects.CategoryArticle;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {

    private static String [] categories = {"Home", "Lifestyle", "Fashion", "Music", "Arts"};
    private CustomizedViewPager viewPager;
    private CategoryFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        viewPager = findViewById(R.id.pager);
        adapter = new CategoryFragmentAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        disableSwipe();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    public static String[] getCategories() {
        return categories;
    }

    public void enableSwipe() {
        viewPager.disableScroll(false);
    }

    public void disableSwipe() {
        viewPager.disableScroll(true);
    }

    public void toArticlePage(View view) {
        Intent intent = new Intent(CategoriesActivity.this, ArticleActivity.class);
        intent.putExtra("id", ""+view.getTag());
        startActivity(intent);
    }
}