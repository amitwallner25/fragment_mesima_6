package com.example.a75shiur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    SQLiteManager ma;
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






        ma = SQLiteManager.instanceOfDatabase(this);
        Button frag1 = findViewById(R.id.frag1btn);
        Button frag2 = findViewById(R.id.frag2btn);

        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentView, firstfragment)
                        .commit();
                Button save1 = findViewById(R.id.Save1);
                EditText ed1 = findViewById(R.id.Editf1);
                TextView tv1 = findViewById(R.id.tv1);
                save1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ma.updateUserToDB(ed1.getText().toString(), null);
                    }
                });
                tv1.setText(ma.getSecondField());

            }
        });
        frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentView, scecondFragment)
                        .commit();
                Button save2 = findViewById(R.id.Savef2);
                EditText ed2 = findViewById(R.id.Editf2);
                TextView tv2 = findViewById(R.id.tv2);
                save2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ma.updateUserToDB(null, ed2.getText().toString());
                    }
                });
                tv2.setText(ma.getFirstField());


            }
        });









    }
}