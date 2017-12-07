package com.example.rodixxi.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] characters = getResources().getStringArray(R.array.Characters);

        CharacterAdapter adapter = new CharacterAdapter(this,
                R.layout.simple_layout_item_1, characters);

        ListView list = (ListView) findViewById(R.id.characterListDinamic);
        list.setAdapter(adapter);
    }
}
