package com.example.brintaudientes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter2 extends FragmentStateAdapter {

    public PagerAdapter2(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        switch (position) {
            case 0:
                return new PlayFragment();
            case 1:
                return new SettingsFragment();
            default:
                return new AudiogramFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
