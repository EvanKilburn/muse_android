package com.example.muse_android.fragments;

import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.muse_android.CategoriesActivity;
import com.example.muse_android.R;
import com.example.muse_android.objects.CategoryArticle;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class LifestyleFragment extends CategoryFragment {

    public LifestyleFragment() {

    }

    public LifestyleFragment(CategoriesActivity categoriesActivity) {
        this.categoriesActivity = categoriesActivity;

        this.categoryName = "Lifestyle";
        this.titles[0] = "Recent";
        this.titles[1] = "More";

        this.layoutName = R.layout.fragment_lifestyle;
        this.recycler = R.id.lifestyleView;
    }

    public LifestyleFragment getInstance() {
        LifestyleFragment fragment = new LifestyleFragment();
        return fragment;
    }
}