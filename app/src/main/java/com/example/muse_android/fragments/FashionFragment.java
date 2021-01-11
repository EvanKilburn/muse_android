package com.example.muse_android.fragments;

import androidx.fragment.app.Fragment;

import com.example.muse_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FashionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FashionFragment extends CategoryFragment {

    public FashionFragment() {
        this.categoryName = "Fashion";
        this.layoutName = R.layout.fragment_fashion;
        this.view = R.id.fashionView;
    }

    public FashionFragment newInstance() {
        FashionFragment fragment = new FashionFragment();
        return fragment;
    }
}