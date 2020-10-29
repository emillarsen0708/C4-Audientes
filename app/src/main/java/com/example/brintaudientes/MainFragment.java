package com.example.brintaudientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.brintaudientes.R;

public class MainFragment extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, parent, false);
        ViewPager2 viewPager = (ViewPager2) view.findViewById(R.id.viewpager3);
        FragmentManager fragmentManager = getChildFragmentManager();
        viewPager.setAdapter(new PagerAdapter(fragmentManager) {

        return view
        }
    }
    }
}