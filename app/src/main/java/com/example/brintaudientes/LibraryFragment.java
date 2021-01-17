package com.example.brintaudientes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> sounds = new ArrayList<>();



   /* private ListViewAdapter adapter;
    private List<String> sounds = new ArrayList<>();



    public static boolean isActionMode = false;
    public static List<String> userSelection = new ArrayList<>();
    public static ActionMode actionMode = null;*/

    //ArrayAdapter antiAdapter;
    //MediaPlayer mediaPlayer;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_library, container, false);

        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            sounds.add(fields[i].getName());


        listView = root.findViewById(R.id.listview_songs);
        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, sounds);
        listView.setAdapter(arrayAdapter);

        setHasOptionsMenu(true);

        }

        return root;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.context_menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_delete) {
            String itemSelected = "Selected items:  \n";
            for (int i = 0; i < listView.getCount(); i++) {
                if (listView.isItemChecked(i)) {
                    itemSelected += listView.getItemAtPosition(i) + "\n";
                }

            }
            Toast.makeText(getActivity(), itemSelected, Toast.LENGTH_SHORT).show();
            System.out.println(itemSelected);

        }
        return super.onOptionsItemSelected(item);
    }


/*listView = (ListView) root.findViewById(R.id.listview_songs);
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
                actionMode = null;
                return true;
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
*/


    private void getSounds(){


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