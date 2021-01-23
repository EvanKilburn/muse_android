package com.example.muse_android.fragments;

import androidx.fragment.app.Fragment;

import com.example.muse_android.CategoriesActivity;
import com.example.muse_android.R;
import com.example.muse_android.objects.CategoryArticle;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MusicFragment extends CategoryFragment {

    public MusicFragment() {

        this.categoryName = "Music";
        this.titles[0] = "Recent";
        this.titles[1] = "More";

        this.layoutName = R.layout.fragment_music;
        this.recycler = R.id.musicView;
    }

    public MusicFragment getInstance() {
        MusicFragment fragment = new MusicFragment();
        return fragment;
    }
}