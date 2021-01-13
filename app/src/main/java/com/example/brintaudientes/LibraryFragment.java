package com.example.brintaudientes;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LibraryFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class LibraryFragment extends Fragment {

    ListView antiListView;
    ArrayList<String> arrayList;


    ArrayAdapter antiAdapter;
    MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_library, container, false);

        antiListView = root.findViewById(R.id.listview_songs);
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

                int resId = LibraryFragment.this
                        .getResources()
                        .getIdentifier(arrayList.get(position), "raw", LibraryFragment.this.getActivity().getPackageName());

                for (int i = 0; i < antiListView.getChildCount() ; i++) {
                    if (position == i){
                        antiListView.getChildAt(i).setBackgroundResource(R.drawable.ic_selected_sound);
                        mediaPlayer = MediaPlayer.create(LibraryFragment.this.getActivity(), resId);
                        mediaPlayer.start();
                    } /*else if (position != i){
                        antiListView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                        //mediaPlayer.stop();
                    }*/
                    
                }

                // Ends the Mediaplayer if a Mediaplayer already exist
                //if (mediaPlayer != null) {
                //  mediaPlayer.release();
                //}

                // Creates a Mediaplayer and start playing from Mediaplayer


            }
        });

        return root;

    }

}