package com.example.brintaudientes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager2.widget.ViewPager2;


import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.concurrent.TimeUnit;


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

}
