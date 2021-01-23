package com.example.muse_android.fragments;

import androidx.fragment.app.Fragment;

import com.example.muse_android.CategoriesActivity;
import com.example.muse_android.R;
import com.example.muse_android.objects.CategoryArticle;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends CategoryFragment {

    public HomeFragment() {

        this.categoryName = "Home";
        this.titles[0] = "Editor's Pick";
        this.titles[1] = "More";

        this.layoutName = R.layout.fragment_home;
        this.recycler = R.id.homeView;
    }

    public HomeFragment getInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }
}