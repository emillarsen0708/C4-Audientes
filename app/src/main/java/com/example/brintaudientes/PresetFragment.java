package com.example.brintaudientes;

import android.media.SoundPool;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class PresetFragment extends Fragment {

    private SoundPool soundPool;
    private int sound1, sound2, sound3, sound4;
    Button play,edit,add1,add2,add3,add4,add5,add6,add7,add8,add9, concurrent, continuous;

    private boolean play_pause_button = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_preset, container, false);

        play = root.findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((play != null) && (play_pause_button)) {
                 play.setBackgroundResource(R.drawable.ic_play_icon);
                 play_pause_button = false; }
                else {
                    if (play != null) play.setBackgroundResource(R.drawable.pause_button);
                    play_pause_button = true;
                }
            }
        });

        add1 = root.findViewById(R.id.select_preset_button_1);
        add1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                LibraryFragment addFragment = new LibraryFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(PresetFragment.this)
                        .replace(((ViewGroup)getView().getParent()).getId(), addFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

                        /*
                LibraryFragment addFragment = new LibraryFragment();
                FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, addFragment, addFragment.getTag());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                         */
            }
        });

        add2 = root.findViewById(R.id.select_preset_button_2);
        add3 = root.findViewById(R.id.select_preset_button_3);
        add4 = root.findViewById(R.id.select_preset_button_4);
        add5 = root.findViewById(R.id.select_preset_button_5);
        add6 = root.findViewById(R.id.select_preset_button_6);
        add7 = root.findViewById(R.id.select_preset_button_7);
        add8 = root.findViewById(R.id.select_preset_button_8);
        add9 = root.findViewById(R.id.plus_button);


        return root;

    }

}
