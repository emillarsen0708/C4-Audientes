package com.example.brintaudientes;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class PlayFragment extends Fragment {
    private Button select_mode;
    boolean isButtonClicked = false;


    public PlayFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_play, container, false);

        select_mode = root.findViewById(R.id.mode_button);

        select_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), SettingsFragment.class);
                intent.putExtra("select_mode", 1000048);
                Bundle bundle = new Bundle();
                boolean isButtonClicked = true;
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.playContainer, new AmbienceFragment());
                transaction.commit();
            }
        });



        return root;
    }

        }
