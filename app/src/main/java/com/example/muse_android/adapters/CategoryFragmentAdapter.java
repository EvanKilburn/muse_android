package com.example.muse_android.adapters;

import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.muse_android.CategoriesActivity;
import com.example.muse_android.CustomizedViewPager;
import com.example.muse_android.fragments.ArtsFragment;
import com.example.muse_android.fragments.CategoryFragment;
import com.example.muse_android.fragments.FashionFragment;
import com.example.muse_android.fragments.HomeFragment;
import com.example.muse_android.fragments.LifestyleFragment;
import com.example.muse_android.fragments.MusicFragment;

public class CategoryFragmentAdapter extends FragmentPagerAdapter {

    CategoriesActivity categoriesActivity;

    public CategoryFragmentAdapter(@NonNull FragmentManager fm, CategoriesActivity categoriesActivity) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.categoriesActivity = categoriesActivity;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        CategoryFragment pageFragment = null;
        if (position == 0) {
            pageFragment = new HomeFragment(this.categoriesActivity);
        } else if (position == 1) {
            pageFragment = new LifestyleFragment(this.categoriesActivity);
        } else if (position == 2) {
            pageFragment = new FashionFragment(this.categoriesActivity);
        } else if (position == 3) {
            pageFragment = new MusicFragment(this.categoriesActivity);
        } else if (position == 4) {
            pageFragment = new ArtsFragment(this.categoriesActivity);
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
