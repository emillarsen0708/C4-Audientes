package com.example.brintaudientes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
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
    private ListView listView;
    private ListViewAdapter adapter;
    private List<String> sounds = new ArrayList<>();

    public static boolean isActionMode = false;
    public static List<String> userSelection = new ArrayList<>();
    public static ActionMode actionMode = null;

    //ArrayAdapter antiAdapter;
    //MediaPlayer mediaPlayer;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_library, container, false);
        getSounds();


        listView = (ListView) root.findViewById(R.id.listview_songs);
        adapter = new ListViewAdapter(sounds,getActivity());
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setAdapter(adapter);

        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context_menu, menu);
                isActionMode = true;
                actionMode = mode;
                return false;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_delete:
                        adapter.removeItems(userSelection);
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                isActionMode = false;
                actionMode = null;
                userSelection.clear();

            }
        });

        return root;
    }

    private void getSounds(){
        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            sounds.add(fields[i].getName());
        }

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