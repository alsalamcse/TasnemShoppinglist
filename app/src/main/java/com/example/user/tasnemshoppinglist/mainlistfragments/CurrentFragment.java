package com.example.user.tasnemshoppinglist.mainlistfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.tasnemshoppinglist.R;
import com.example.user.tasnemshoppinglist.data.Product;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        //4.
        return view;
    }
    //read and listen data from firebase
    private void readAndListen()
    {
        //5.to get user Email.. user info

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String email = user.getEmail();
        email = email.replace('.', '*');
        //6. building data referance=data path=data addresss
        DatabaseReference reference;
        //// todo לקבלת קישור למסד הניתונים שלנו
        reference = FirebaseDatabase.getInstance().getReference();
        // 7.saving data on the firebase database
        reference.child(email).child("my list").
                //todo בפעם הראשונה שמופעל המאזין מקבלים העתק לכל הניתונים תחת כתובת זו
                addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)//todo העתק מהניתונים שהורדנו
                    {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Product p = ds.getValue(Product.class);
                    Log.d("SL", p.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
}


}
