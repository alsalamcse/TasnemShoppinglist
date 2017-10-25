package com.example.user.tasnemshoppinglist.mainlistfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.tasnemshoppinglist.R;

/**
 * A simple {@link Fragment} subclass.
 */
    public class CurrentFragment extends Fragment
{
    private TextView tvTotal,tvTotalvalue,tvCount,tvCountValue;
    private ImageButton imbSave;
    private ListView lstvCurrent;



    public CurrentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_current, container, false);
        tvTotal=(TextView) view.findViewById(R.id.tvTotal);
        tvTotalvalue=(TextView) view.findViewById(R.id.tvTotalvalue);
        tvCount=(TextView)view.findViewById(R.id.tvCount);
        tvCountValue=(TextView) view.findViewById(R.id.tvCountValue);
        imbSave=(ImageButton) view.findViewById(R.id.imbSave);
        lstvCurrent=(ListView)view.findViewById(R.id.lstvCurrent);
        String[]ar={"tasnem","haya","adham","sozan"};
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,)
     return view;
    }


}
