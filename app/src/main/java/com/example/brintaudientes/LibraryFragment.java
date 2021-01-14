package com.example.brintaudientes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LibraryFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class LibraryFragment extends Fragment {

    ListView antiListView;
    List<SoundModel> soundList;

    //ArrayAdapter antiAdapter;
    //MediaPlayer mediaPlayer;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_library, container, false);

        antiListView = (ListView) root.findViewById(R.id.listview_songs);

        soundList = new ArrayList<>();
        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i < fields.length; i++) {

            try {
                soundList.add(new SoundModel(false, fields[i].getInt(i)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        CustomAdapter adapter = new CustomAdapter(getActivity(), soundList);
        antiListView.setAdapter(adapter);

        antiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                SoundModel model = soundList.get(i);
                if (model.isSelected()) {
                    model.setSelected(false);
                }else{
                    model.setSelected(true);
                    soundList.set(i, model);
                }

                // now update adapter
                adapter.updateRecords(soundList);

            }
        });
        return root;

    }


}

        /*antiListView = root.findViewById(R.id.listview_songs);
        arrayList = new ArrayList<String>();
        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            arrayList.add(fields[i].getName());
        }
        antiAdapter = new ArrayAdapter(getActivity(), R.layout.listview_text_color, arrayList);
        antiListView.setAdapter(antiAdapter);


        antiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                // Gør at de valgte sange ikke afspilles samtidig
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }




                int resId = getResources().getIdentifier(arrayList.get(position), "raw", LibraryFragment.this.getActivity().getPackageName());
                mediaPlayer = MediaPlayer.create(LibraryFragment.this.getActivity(), resId);
                mediaPlayer.start();
            }
        });

        return root;
    }

}

         */