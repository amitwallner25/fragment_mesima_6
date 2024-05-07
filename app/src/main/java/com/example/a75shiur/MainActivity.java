package com.example.a75shiur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstfragment = FirstFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentView, firstfragment).commit();
    }
}