package com.miczon.task4_fragments.fragments.adapter;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;



/*FragmentStatePagerAdapter is used when no of pages is not fixed and create at run time.
 FragmentStatePagerAdapter Keeps in memory only the current fragment displayed on the screen.
  This is memory efficient and should be used in applications with dynamic fragments. (where the number of fragments is not fixed.).
 */

//FragmentPagerAdapter is used when no of pages is fixed
public class ViewPagerAdapter extends FragmentPagerAdapter {

 private final List<Fragment> fragmentList = new ArrayList<>();
 private final List<String> tabsList = new ArrayList<>();


    public ViewPagerAdapter(@NonNull FragmentManager fm) {

        super(fm);
    }

    public void addFragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        tabsList.add(title);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);

    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    //similar to getItem
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Log.d("fdfsdf", "getItem: " + position);
        return super.getPageTitle(position);

    }

}
