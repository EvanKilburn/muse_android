package com.example.muse_android.fragments;

import androidx.fragment.app.Fragment;

import com.example.muse_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicFragment extends CategoryFragment {

    public MusicFragment() {
        this.categoryName = "Music";
        this.layoutName = R.layout.fragment_music;
        this.view = R.id.musicView;
    }

    public MusicFragment newInstance() {
        MusicFragment fragment = new MusicFragment();
        return fragment;
    }
}