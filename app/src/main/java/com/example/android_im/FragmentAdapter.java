package com.example.android_im;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

class FragmentAdapter extends FragmentPagerAdapter {

    List<Fragment> list;
    List<String> title;

    public FragmentAdapter(@NonNull FragmentManager fm, List<Fragment> list, List<String> title) {
        super(fm);
        this.list = list;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    /*让TabLayout能获取到title*/
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
