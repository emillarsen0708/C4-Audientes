package com.example.brintaudientes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;


import android.app.FragmentManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

// todo: Få styr på skærmvending så player ikke kører videre mens player står i pause mode

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    

    PlayFragment playFragment = new PlayFragment();
    VolumeFragment volumeFragment = new VolumeFragment();
    LibraryFragment libraryFragment = new LibraryFragment();
    static MediaPlayer mMediaPlayer;
    int currentIndex = 0;
    private Runnable runnable;
    private AudioManager SoundManager;
    PresetFragment presetFragment = new PresetFragment();
    Fragment selectedFragment = presetFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView buttNav = findViewById(R.id.bottom);
        buttNav.setOnNavigationItemSelectedListener(naviListner);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, libraryFragment, "3").hide(presetFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, volumeFragment, "2").hide(volumeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, presetFragment, "1").commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener naviListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.nav_play:
                            getSupportFragmentManager().beginTransaction()
                                    .hide(selectedFragment)
                                    .show(presetFragment)
                                    .commit();
                            selectedFragment = presetFragment;
                            return true;
                        case R.id.nav_vol:
                            getSupportFragmentManager().beginTransaction()
                                    .hide(selectedFragment)
                                    .show(volumeFragment)
                                    .commit();
                            selectedFragment = volumeFragment;
                            return true;
                        case R.id.nav_preset:
                            getSupportFragmentManager().beginTransaction()
                                    .hide(selectedFragment)
                                    .show(libraryFragment)
                                    .commit();
                            selectedFragment = libraryFragment;
                            return true;
                    }
                    return false;
                }
            };



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

    @Override
    public void onBackStackChanged() {

    }
}
