package com.example.a75shiur;

import static android.view.View.inflate;

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
 * Use the {@link ScecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScecondFragment extends Fragment {

    public ScecondFragment() {
        // Required empty public constructor
    }
    SQLiteManager ma;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment scecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScecondFragment newInstance() {
        ScecondFragment fragment = new ScecondFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        View view = inflater.inflate(R.layout.fragment_scecond, container, false);
        Button save2 = view.findViewById(R.id.Savef2);
        EditText ed2 = view.findViewById(R.id.Editf2);
        TextView tv2 = view.findViewById(R.id.tv2);

        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ma.updateUserToDB(null, ed2.getText().toString());
            }
        });
        tv2.setText(ma.getTextFromFragments()[0]);



         return view;
    }





}