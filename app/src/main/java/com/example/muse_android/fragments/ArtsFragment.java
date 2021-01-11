package com.example.muse_android.fragments;

import androidx.fragment.app.Fragment;

import com.example.muse_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArtsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArtsFragment extends CategoryFragment {

    public ArtsFragment() {
        this.categoryName = "Arts";
        this.layoutName = R.layout.fragment_arts;
        this.view = R.id.artsView;
    }

    public ArtsFragment newInstance() {
        ArtsFragment fragment = new ArtsFragment();
        return fragment;
    }
}