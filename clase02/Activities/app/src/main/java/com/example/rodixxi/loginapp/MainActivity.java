package com.example.rodixxi.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView wellcomeMessage = (TextView) findViewById(R.id.wellcomeMessage);
        wellcomeMessage.setText(wellcomeMessage
                .getText().toString()
                .concat(" ")
                .concat(name)
                .concat("!"));
    }
}