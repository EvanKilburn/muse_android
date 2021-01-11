package com.example.muse_android.fragments;

import androidx.fragment.app.Fragment;

import com.example.muse_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LifestyleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LifestyleFragment extends CategoryFragment {

    public LifestyleFragment() {
        this.categoryName = "Lifestyle";
        this.layoutName = R.layout.fragment_lifestyle;
        this.view = R.id.lifestyleView;
    }

    public LifestyleFragment newInstance() {
        LifestyleFragment fragment = new LifestyleFragment();
        return fragment;
    }
}