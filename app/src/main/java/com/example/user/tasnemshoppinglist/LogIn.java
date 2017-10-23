package com.example.user.tasnemshoppinglist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.tasnemshoppinglist.mainlistfragments.MainListActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {

    private Button btnUp;
    private Button btnIn;
    private EditText etUsername;
    private EditText etPassword;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etUsername=(EditText)findViewById(R.id.etUsername);
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
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

    }
    private void signIn(String email,String passw){
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        })
    }

}
    