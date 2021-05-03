package com.miczon.task4_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.miczon.task4_fragments.fragments.FirstFragment;
import com.miczon.task4_fragments.fragments.SecondFragment;
import com.miczon.task4_fragments.fragments.ThirdFragment;
import com.miczon.task4_fragments.fragments.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViews();

        // setting/Initializing up the adapter
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // add the fragments
        viewPagerAdapter.addFragment(new FirstFragment(),"First");
        viewPagerAdapter.addFragment(new SecondFragment(),"Second");
        viewPagerAdapter.addFragment(new ThirdFragment(),"Third");

        // Set the adapter
        viewPager.setAdapter(viewPagerAdapter);

        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().
        tabLayout.setupWithViewPager(viewPager);
        //setting icons
        tabLayout.getTabAt(0).setText("Days");
        tabLayout.getTabAt(1).setText("Months");
        tabLayout.getTabAt(2).setText("Islamic months");

    }

    private void getViews() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewpager);
    }
}