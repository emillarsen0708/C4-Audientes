package com.example.brintaudientes;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
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
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<String> {

    private List<String> sounds = new ArrayList<>();
    private Context context;
    static int count = 0;
    CheckBox checkBox;
    TextView soundNames;
    ViewHolder holder;

   SparseBooleanArray mCheckedStates = new SparseBooleanArray(sounds.size());

    public ListViewAdapter(List<String> sounds, Context context) {
        super(context, R.layout.item_layout, sounds);
        this.context = context;
        this.sounds = sounds;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_layout, parent, false);
            holder = new ViewHolder();
            holder.txtView = (TextView) convertView.findViewById(R.id.song_name);
            holder.chkBox = (CheckBox) convertView.findViewById(R.id.checkbox);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtView.setText(sounds.get(position));
        holder.chkBox.setTag(position);
        holder.chkBox.setChecked(Update(sounds.get(position)));
        count = UpdateCountValue("jep");

        holder.chkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int position = (int) buttonView.getTag();

                if (isChecked) {
                    count++;
                    SaveCount("jep", count);
                    SaveIntoSharepreference(sounds.get(position), true);
                    Log.d(sounds.get(position), "Checked");
                } else if (!isChecked) {
                    count--;
                    SaveCount("jep", count);
                    SaveIntoSharepreference(sounds.get(position), false);
                    Log.d(sounds.get(position), "Unchecked");
                } if (count >= 5) {
                    count--;
                    SaveCount("jep", count);
                    Toast.makeText(context, "Du kan ikke vælge flere end " + (count) + " sange", Toast.LENGTH_LONG).show();
                     //buttonView.setChecked(false);
                } else {
                    sounds.get(position);
                }
               /* if (LibraryFragment.userSelection.contains(sounds.get(getPosition))){
                        LibraryFragment.userSelection.remove(sounds.get(getPosition));
                    } else{
                        LibraryFragment.userSelection.add(sounds.get(getPosition));
                    }
                    Toast.makeText(context,"Antal Item: " +LibraryFragment.userSelection.size(),Toast.LENGTH_SHORT).show();*//*
                }*/
            }
        });
        System.out.println((count));
        return convertView;
    }

    public void removeItems(List<String> items) {
        for (String item : items) {
            sounds.remove(item);
        }
        notifyDataSetChanged();
    }

    private void SaveIntoSharepreference(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    private boolean Update(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        boolean checkBoxValue = sharedPreferences.getBoolean(key, false);
        return checkBoxValue;
    }

    private void SaveCount(String key, int countValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, countValue);
        editor.apply();
    }


    private int UpdateCountValue(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        return sharedPreferences.getInt(key, 0);
    }
}

