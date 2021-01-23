package com.example.muse_android.fragments;

import androidx.fragment.app.Fragment;

import com.example.muse_android.CategoriesActivity;
import com.example.muse_android.R;
import com.example.muse_android.objects.CategoryArticle;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FashionFragment extends CategoryFragment {

    public FashionFragment() {

        this.categoryName = "Fashion";
        this.titles[0] = "Recent";
        this.titles[1] = "More";

        this.layoutName = R.layout.fragment_fashion;
        this.recycler = R.id.fashionView;
    }

    public FashionFragment getInstance() {
        FashionFragment fragment = new FashionFragment();
        return fragment;
    }
}