package com.example.brintaudientes;

import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//import static com.example.brintaudientes.R.xml.preset_add_highlight_rectangle;
import static com.example.brintaudientes.R.xml.preset_add_rectangle;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AmbienceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AmbienceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AmbienceFragment() {
        // Required empty public constructor
    }

    Button add1, add2, add3, add4, add5, add6, add7, add8, add9;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AmbienceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AmbienceFragment newInstance(String param1, String param2) {
        AmbienceFragment fragment = new AmbienceFragment();
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
        View root = inflater.inflate(R.layout.fragment_ambience, container, false);

        add1 = root.findViewById(R.id.select_preset_button_1);
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatePresetFragment createPresetFragment = new CreatePresetFragment();
                FragmentManager manager = getParentFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.frontpage, createPresetFragment, createPresetFragment.getTag())
                        .commit();
            }

       // });
         //   }
        });
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

