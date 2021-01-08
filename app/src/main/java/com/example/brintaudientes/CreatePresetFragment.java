package com.example.brintaudientes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreatePresetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreatePresetFragment extends Fragment {

    Button add1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreatePresetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreatePreset.
     */
    // TODO: Rename and change types and number of parameters
    public static CreatePresetFragment newInstance(String param1, String param2) {
        CreatePresetFragment fragment = new CreatePresetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_create_preset, container, false);

        add1 = root.findViewById(R.id.add_sound_1);
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SleepChooseSongFragment addSoundFragment = new SleepChooseSongFragment();
                FragmentManager manager = getParentFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.nav_play, addSoundFragment, addSoundFragment.getTag())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return root;
    }


}