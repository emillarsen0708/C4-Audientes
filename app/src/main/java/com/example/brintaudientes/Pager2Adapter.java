package com.example.brintaudientes;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Pager2Adapter extends FragmentStateAdapter {
    public Pager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
            return new MainFragment();
            case 1:
                return new MaybeFragment();
            default:
                return new PresetFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
