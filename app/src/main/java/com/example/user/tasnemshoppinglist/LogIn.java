package com.example.user.tasnemshoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.tasnemshoppinglist.mainlistfragments.MainListActivity;

public class LogIn extends AppCompatActivity {

    private Button btnUp;
    private Button btnIn;
    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        btnIn=(Button)findViewById(R.id.btnIn);
        btnUp=(Button)findViewById (R.id.btnUp);
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent i=new Intent(getBaseContext(), SignUp.class);
                    startActivity(i);


            }
        });





    }


}
    