package com.example.brintaudientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.brintaudientes.R;

public class PresetFragment extends Fragment {

    private String title;
    private int page;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        final View Rootview = inflater.inflate(R.layout.fragment_preset, parent, false);
        ViewPager viewPager = (ViewPager) Rootview.findViewById(R.id.viewpager);
        FragmentManager fragmentManager = getChildFragmentManager();
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 1;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return false;
            }
        });
        return Rootview;
    }
}