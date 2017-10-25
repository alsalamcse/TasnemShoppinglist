package com.example.user.tasnemshoppinglist.mainlistfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.tasnemshoppinglist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {
    private ListView lstvHistory;


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_history, container, false);
        lstvHistory=(ListView) view.findViewById(R.id.lstvHistory);
        return view;
    }

}
