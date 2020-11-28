package com.example.brintaudientes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {

    TabLayout layout;
    ViewPager2 viewPager2;
    FragmentManager fragmentManager;


    Button mode_button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new PagerAdapter2(this));

        mode_button = findViewById(R.id.mode_button);
        mode_button.setOnClickListener((View.OnClickListener) this);

        layout = findViewById(R.id.tab_layout2);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                layout, viewPager2, (tab, position) -> {
                    switch (position) {
                        case 0: {
                            tab.setText("PLAY MODE");
                            tab.setIcon(R.drawable.ic_settings_2);
                            break;
                        }
                        case 1: {
                            tab.setText("SETTINGS");
                            tab.setIcon(R.drawable.ic_group_45);
                            break;
                        }
                        case 2: {
                            tab.setText("AUDIOGRAM");
                            tab.setIcon(R.drawable.ic_graph);
                            break;
                        }
                    }
                }
        );
        tabLayoutMediator.attach();


    }
    @Override
    public void onClick (View v) {
        if (v == mode_button) {

        }
    }



}
