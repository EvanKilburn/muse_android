package com.example.muse_android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muse_android.adapters.CategoryAdapter;
import com.example.muse_android.objects.CategoryArticle;
import com.example.muse_android.requests.fetchCategoryData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public abstract class CategoryFragment extends Fragment {

    public ArrayList<CategoryArticle> articles = new ArrayList<>();
    public RecyclerView.Adapter adapter;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView recyclerView;
    public boolean canScroll = true;
    protected String categoryName;
    protected int pageNumber = 1;
    protected static int layoutName;
    protected static int view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchCategoryData process = new fetchCategoryData(this.categoryName, this.pageNumber, this);
        process.execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(this.layoutName, container, false);

        recyclerView = view.findViewById(this.view);
        layoutManager = new LinearLayoutManager(view.getContext());
        adapter = new CategoryAdapter(view.getContext(), articles);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1) && canScroll) {
                    pageNumber += 1;
                    canScroll = false;
                    fetchCategoryData process = new fetchCategoryData(categoryName, pageNumber, getThis());
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