package com.example.muse_android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.MotionEventCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muse_android.CategoriesActivity;
import com.example.muse_android.R;
import com.example.muse_android.adapters.CategoryAdapter;
import com.example.muse_android.adapters.CategoryCarouselAdapter;
import com.example.muse_android.objects.AllCategory;
import com.example.muse_android.objects.CategoryArticle;
import com.example.muse_android.requests.fetchCategoryData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public abstract class CategoryFragment extends Fragment {

    public ArrayList<CategoryArticle> articles = new ArrayList<>();
    public ArrayList<CategoryArticle> carouselArticles = new ArrayList<>();
    public int carouselSize = 10;
    public String [] titles = new String[2];

    public RecyclerView.Adapter adapter;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView recyclerView;

    public boolean canScroll = true;
    protected String categoryName;
    protected int pageNumber = 2;
    protected int index = 0;
    protected int layoutName;
    protected int recycler;

    public abstract CategoryFragment getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < CategoriesActivity.getCategories().length; i++) {
            if (CategoriesActivity.getCategories()[i].equals(categoryName)) {
                index = i;
            }
        }

        for (int j = 0; j < carouselSize; j++) {
            carouselArticles.add(AllCategory.allCategory[index].get(j));
        }

        for (int k = carouselSize + 1; k < 2 * carouselSize; k++) {
            articles.add(AllCategory.allCategory[index].get(k));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(this.layoutName, container, false);

        recyclerView = view.findViewById(this.recycler);
        layoutManager = new LinearLayoutManager(view.getContext());
        adapter = new CategoryAdapter(articles, carouselArticles, titles, view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1) && canScroll) {
                    pageNumber += 1;
                    canScroll = false;

                    fetchCategoryData process = new fetchCategoryData(categoryName, pageNumber, 10, index);
                    process.execute();
                }
            }
        });

        return view;
    }

    private CategoryFragment getThis () {
        return this;
    }
}