package com.example.brintaudientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.brintaudientes.R;

public class AudiogramFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        final View Rootview = inflater.inflate(R.layout.fragment_audiogram, parent, false);
        ViewPager viewPager = (ViewPager) Rootview.findViewById(R.id.viewpager);
        FragmentManager fragmentManager = getChildFragmentManager();
        viewPager.setAdapter(new PagerAdapter(fragmentManager, 3));
        return Rootview;
    }
}