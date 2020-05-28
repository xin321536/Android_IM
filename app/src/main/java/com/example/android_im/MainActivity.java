package com.example.android_im;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.android_im.Fragment.ContactsFragment;
import com.example.android_im.Fragment.DynamicFragment;
import com.example.android_im.Fragment.MessagesFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager vp;
    private TabLayout tab;
    private NavigationView navigation_drawer;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDrawer();
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        titleList = new ArrayList<>();
        fragments.add(new MessagesFragment());
        fragments.add(new ContactsFragment());
        fragments.add(new DynamicFragment());
        titleList.add("消息");
        titleList.add("联系人");
        titleList.add("动态");
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titleList);
        vp.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
        tab.setTabMode(TabLayout.MODE_FIXED);
        tab.setupWithViewPager(vp);
    }

    private void initDrawer() {
        navigation_drawer.setItemIconTintList(null);
        //ToolBar名称
        //支持设置操作栏
//        setSupportActionBar(toolbar);
        //关联ToolBar和侧滑栏
        toggle = new ActionBarDrawerToggle(this, drawer,toolbar, R.string.app_name, R.string.app_name);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        navigation_drawer = (NavigationView) findViewById(R.id.navigation_drawer);
        drawer = (DrawerLayout) findViewById(R.id.drawer);

    }
}
