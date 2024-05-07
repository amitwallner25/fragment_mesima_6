package com.example.a75shiur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstfragment = FirstFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentView, firstfragment).commit();
        ScecondFragment scecondFragment = ScecondFragment.newInstance();

        Bundle args = new Bundle();
        args.putString("test" , "frag1");
        firstfragment.setArguments(args);






        Button frag1 = findViewById(R.id.frag1btn);
        Button frag2 = findViewById(R.id.frag2btn);


        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentView, scecondFragment)
                        .commit();
            }
        });
        frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentView, scecondFragment)
                        .commit();
            }
        });

    }
}