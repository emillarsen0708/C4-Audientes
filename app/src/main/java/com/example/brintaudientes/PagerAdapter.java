package com.example.brintaudientes;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;


    public PagerAdapter(@NonNull FragmentManager fm){

        super(fm);
        this.numOfTabs = numOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new SettingsFragment();
            case 1:
                fragment = new PlayerFragment();
            case 2:
                fragment = new AudiogramFragment();
        }
        return fragment;

    }


    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;
        if (position == 1)
            title = "SETTINGS";
         else if (position == 1)
             title = "PLAYER0";
         else if (position == 2)
             title = "AUDIOGRAM";
         return title;
    }

    public void setNumOfTabs(int numOfTabs) {
        this.numOfTabs = numOfTabs;
    }
}
