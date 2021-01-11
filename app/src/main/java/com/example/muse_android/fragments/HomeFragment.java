package com.example.muse_android.fragments;

import androidx.fragment.app.Fragment;

import com.example.muse_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends CategoryFragment {

    public HomeFragment() {
        this.categoryName = "Home";
        this.layoutName = R.layout.fragment_home;
        this.view = R.id.homeView;
    }

    public HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }
}