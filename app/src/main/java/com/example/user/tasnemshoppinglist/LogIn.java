package com.example.user.tasnemshoppinglist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.tasnemshoppinglist.mainlistfragments.MainListActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {

    private Button btnUp;
    private Button btnIn;
    private EditText etEmail;
    private EditText etPassword;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

        btnIn=(Button)findViewById(R.id.btnIn);
        btnUp=(Button)findViewById (R.id.btnUp);
       btnIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent1 = new Intent(LogIn.this, MainListActivity.class);
               startActivity(intent1);
               finish();
           }
       });
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent i=new Intent(getBaseContext(), SignUp.class);
                    startActivity(i);


            }
        });

    }
    private void dataHandler() {
        String stEmail = etEmail.getText().toString();
        String stPassword = etPassword.getText().toString();
    }

    private void signIn(String email,String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(LogIn.this,
                new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LogIn.this, "signIn Successful", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LogIn.this,MainListActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(LogIn.this, "signIn failed" + task.getException().getMessage(),
                            Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }

            }
        });


        }

    }






    