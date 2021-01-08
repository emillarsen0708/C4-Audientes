package com.example.brintaudientes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;



import android.app.FragmentManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

// todo: Få styr på skærmvending så player ikke kører videre mens player står i pause mode

public class MainActivity extends AppCompatActivity {

    static MediaPlayer mMediaPlayer;
    PlayFragment playFragment;
    SettingsFragment settingsFragment;
    AudiogramFragment audiogramFragment;
    PresetFragment presetFragment;
    int currentIndex = 0;
    private Runnable runnable;
    private AudioManager SoundManager;
    private final BottomNavigationView.OnNavigationItemSelectedListener naviListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_play:
                            if(playFragment == null)
                            selectedFragment = new PlayFragment();
                            break;
                        case R.id.nav_vol:
                            if(settingsFragment == null)
                            selectedFragment = new SettingsFragment();
                            break;
                        case R.id.nav_preset:
                            if(presetFragment == null)
                            selectedFragment = new PresetFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment)
                            .addToBackStack(null).commit();
                        return true;
                    }
                    /*private final BottomNavigationView.OnNavigationItemReselectedListener naviReListner = new BottomNavigationView.OnNavigationItemReselectedListener() {
                        @Override
                        public void onNavigationItemReselected(@NonNull MenuItem item) {
                        }*/
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView buttNav = findViewById(R.id.bottom);
        buttNav.setOnNavigationItemSelectedListener(naviListner);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new PlayFragment()).commit();
    }
}




    /*
        viewPager2.setAdapter(new PagerAdapter2(this));

        layout = findViewById(R.id.tab_layout2);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                layout, viewPager2, (tab, position) -> {

                switch (position) {
                case 0: {
                    tab.setText("PLAY MODE");
                    tab.setIcon(R.drawable.tab_settings_2);
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
*/


