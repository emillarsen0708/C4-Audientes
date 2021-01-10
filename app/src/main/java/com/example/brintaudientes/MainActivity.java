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
    

    PlayFragment playFragment;
    VolumeFragment volumeFragment;
    AudiogramFragment audiogramFragment;
    static MediaPlayer mMediaPlayer;
    int currentIndex = 0;
    private Runnable runnable;
    private AudioManager SoundManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView buttNav = findViewById(R.id.bottom);
        buttNav.setOnNavigationItemSelectedListener(naviListner);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new PresetFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener naviListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_play:
                            selectedFragment = new PresetFragment();
                            break;
                        case R.id.nav_vol:
                            selectedFragment = new VolumeFragment();
                            break;
                        case R.id.nav_preset:
                            selectedFragment = new LibraryFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
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
