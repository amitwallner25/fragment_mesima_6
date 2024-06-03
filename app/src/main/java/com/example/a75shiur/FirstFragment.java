package com.example.a75shiur;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {
    public FirstFragment() {
        // Required empty public constructor
    }
    SQLiteManager ma;
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        String [] x ;
        ma = new SQLiteManager(getContext());
        Button save1 = view.findViewById(R.id.Save1);
        EditText ed1 = view.findViewById(R.id.Editf1);
        TextView tv2 = view.findViewById(R.id.tv2);
        x = ma.getTextFromFragments();
        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ma.savetexttodatabase(ed1.getText().toString(),x[1]);
            }
        });

        tv2.setText(x[1]);

        return view;

    }





}