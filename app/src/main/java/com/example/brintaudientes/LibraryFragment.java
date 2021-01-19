package com.example.brintaudientes;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.example.brintaudientes.PresetFragment.mediaPlayer;

public class LibraryFragment extends Fragment {

    private ListView libraryListView;
    private ListViewAdapter adapter;
    private final List<String> sounds = new ArrayList<>();
    private LibraryEditFragment libraryEditFragment;
    ArrayAdapter<String> arrayAdapter;
    Field[] fields = R.raw.class.getFields();

    public LibraryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_library_2, container, false);
        for (int i = 0; i < fields.length; i++) {
            sounds.add(fields[i].getName());
        }

        libraryListView = root.findViewById(R.id.listview_songs_edit);
        arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.listview_text_color, sounds);
        libraryListView.setAdapter(arrayAdapter);

        libraryListView.setOnItemClickListener((parent, view, position, id) -> {
            view.setSelected(true);

            if (mediaPlayer != null) {
                mediaPlayer.release();
            }

            int resId = getResources().getIdentifier(sounds.get(position), "raw", getActivity().getPackageName());
            mediaPlayer = MediaPlayer.create(getActivity(), resId);
            mediaPlayer.start();

        });


        return root;
    }
}