package com.example.rodixxi.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rodixxi on 23/11/17.
 */

public class CharacterAdapter extends ArrayAdapter<MyCharacter> {

    private int layoutId;


    public CharacterAdapter(Context context, int resourceId, ArrayList<MyCharacter> charactersList) {
        super(context, 0,charactersList);
        layoutId = resourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyCharacter item = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);
        }
        TextView itemName = (TextView) convertView.findViewById(R.id.)
        return super.getView(position, convertView, parent);
    }
}
