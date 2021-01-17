package com.example.brintaudientes;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<String> implements CompoundButton.OnCheckedChangeListener {

    private List<String> sounds = new ArrayList<>();
    SparseBooleanArray mCheckStates = new SparseBooleanArray(sounds.size());
    private final Context context;
    static int count;


    public ListViewAdapter(List<String> sounds, Context context) {
        super(context, R.layout.item_layout, sounds);
        this.context = context;
        this.sounds = sounds;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        final ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = inflater.inflate(R.layout.item_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.cb = view.findViewById(R.id.checkbox);
            viewHolder.sn = view.findViewById(R.id.song_name);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();}

        viewHolder.sn.setText(sounds.get(position));
        viewHolder.cb.setTag(position);
        viewHolder.cb.setId(position);
        viewHolder.cb.setChecked(mCheckStates.get(position, false));
        viewHolder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int position = (int) buttonView.getTag();
                if (isChecked && count >= 4) {
                    buttonView.setChecked(false);
                    mCheckStates.put((Integer) buttonView.getTag(), false);
                } else {
                    if (isChecked) {
                        buttonView.setChecked(true);
                        mCheckStates.put((Integer) buttonView.getTag(), true);
                        LibraryFragment.userSelection.add(LibraryFragment.sounds.get(position));
                        count++;
                    } else {
                        buttonView.setChecked(false);
                        mCheckStates.put((Integer) buttonView.getTag(), false);
                        LibraryFragment.userSelection.remove(LibraryFragment.sounds.get(position));
                        count--;
                    }
                    System.out.println(count);
                }
            }
        });

        return view;
            }

       /* if (count >= 5) {
            Toast.makeText(context, "Du kan ikke vælge flere end " + (count - 1) + " sange", Toast.LENGTH_LONG).show();
            buttonView.setChecked(false);
            mCheckStates.put((Integer) buttonView.getTag(), isChecked);
            count--;
        } else {
        }*/

         /*   if (LibraryFragment.userSelection.contains(sounds.get(position))) {
                LibraryFragment.userSelection.remove(sounds.get(position));
            } else {
                LibraryFragment.userSelection.add(sounds.get(position));
            }
            Toast.makeText(context, "Antal Item: " + LibraryFragment.userSelection.size(), Toast.LENGTH_SHORT).show();
        }*/


        public void removeItems (List < String > items) {
            for (String item : items) {
                sounds.remove(item);
            }
            notifyDataSetChanged();
        }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}

