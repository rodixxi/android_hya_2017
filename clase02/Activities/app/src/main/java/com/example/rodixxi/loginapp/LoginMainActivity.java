package com.example.rodixxi.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);


        Log.d("none", "onCreate");
    }

    public void clickLogin(View view) {
        EditText name = (EditText) findViewById(R.id.email);
        EditText pass = (EditText) findViewById(R.id.password);

        if (name.getText().toString().equals("admin")){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("name", name.getText().toString());
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "User or Pass \nIncorrect!",
                    Toast.LENGTH_LONG).show();
            name.setText("");
            pass.setText("");
            name.requestFocus();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("none", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("none", "onPause");
    }

    @Override
    protected void onStop() {
        Log.d("none", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("none", "OnDestroy");
        super.onDestroy();
    }
}
