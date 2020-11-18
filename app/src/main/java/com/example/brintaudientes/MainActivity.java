package com.example.brintaudientes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager2.widget.ViewPager2;


import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {

    TabLayout layout;
    ViewPager2 viewPager2;

    PlayFragment playFragment;
    SettingsFragment settingsFragment;
    AudiogramFragment audiogramFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new PagerAdapter2(this));

        layout = findViewById(R.id.tab_layout2);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                layout, viewPager2, (tab, position) -> {
                    switch (position) {
                        case 0: {
                            tab.setText("PLAY MODE");
                            tab.setIcon(R.drawable.play_button);
                            break;
                        }
                        case 1: {
                            tab.setText("SETTINGS");
                            tab.setIcon(R.drawable.settings_icon);
                            break;
                        }
                        case 2: {
                            tab.setText("AUDIOGRAM");
                            tab.setIcon(R.drawable.graph_icon);
                            break;
                        }
                    }
                }
        );
        tabLayoutMediator.attach();


    }

}
