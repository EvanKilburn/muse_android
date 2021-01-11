package com.example.muse_android.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.muse_android.CategoriesActivity;
import com.example.muse_android.fragments.ArtsFragment;
import com.example.muse_android.fragments.CategoryFragment;
import com.example.muse_android.fragments.FashionFragment;
import com.example.muse_android.fragments.HomeFragment;
import com.example.muse_android.fragments.LifestyleFragment;
import com.example.muse_android.fragments.MusicFragment;

public class CategoryFragmentAdapter extends FragmentPagerAdapter {

    public CategoryFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        CategoryFragment pageFragment = null;
        if (position == 0) {
            pageFragment = new HomeFragment();
        } else if (position == 1) {
            pageFragment = new LifestyleFragment();
        } else if (position == 2) {
            pageFragment = new FashionFragment();
        } else if (position == 3) {
            pageFragment = new MusicFragment();
        } else if (position == 4) {
            pageFragment = new ArtsFragment();
        }
        position = position + 1;
        return pageFragment;
    }

    @Override
    public int getCount() {
        return CategoriesActivity.getCategories().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return CategoriesActivity.getCategories()[position];
    }
}
