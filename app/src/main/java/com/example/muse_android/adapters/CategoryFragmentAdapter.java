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
import com.example.muse_android.objects.AllCategory;

public class CategoryFragmentAdapter extends FragmentPagerAdapter {

    public CategoryFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        CategoryFragment pageFragment = AllCategory.fragments[position];
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
