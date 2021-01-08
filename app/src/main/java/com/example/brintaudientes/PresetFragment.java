package com.example.brintaudientes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PresetFragment extends Fragment {

    Button edit,add1,add2,add3,add4,add5,add6,add7,add8,add9;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ambience, container, false);

        edit = root.findViewById(R.id.edit_preset_button);
        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                SleepChooseSongFragment addFragment = new SleepChooseSongFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(PresetFragment.this)
                        .replace(((ViewGroup)getView().getParent()).getId(), addFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

                        /*
                SleepChooseSongFragment addFragment = new SleepChooseSongFragment();
                FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, addFragment, addFragment.getTag());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                         */
            }
        });

        add1 = root.findViewById(R.id.select_preset_button_1);
        add2 = root.findViewById(R.id.select_preset_button_2);
        add3 = root.findViewById(R.id.select_preset_button_3);
        add4 = root.findViewById(R.id.select_preset_button_4);
        add5 = root.findViewById(R.id.select_preset_button_5);
        add6 = root.findViewById(R.id.select_preset_button_6);
        add7 = root.findViewById(R.id.select_preset_button_7);
        add8 = root.findViewById(R.id.select_preset_button_8);
        add9 = root.findViewById(R.id.select_preset_button_9);


        return root;

    }

}
