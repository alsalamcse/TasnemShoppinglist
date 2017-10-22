package com.example.user.tasnemshoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private EditText edUsername;
    private EditText edEmail;
    private EditText edPassword;
    private Button btnSave;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        edEmail=(EditText) findViewById(R.id.edEmail);
        edUsername=(EditText) findViewById(R.id.edUsername);
        edPassword=(EditText) findViewById(R.id.edPassword);
        btnSave=(Button) findViewById(R.id.btnSave);

        auth = FirebaseAuth.getInstance();
//        firebaseUser = auth.getCurrentUser();
//        if (firebaseUser == null) {
//            startActivity(new Intent(this, LogIn.class));
//            finish();
//            return;
//        } else {
//            String edUsername = firebaseUser.getDisplayName();
//            if (firebaseUser.getPhotoUrl() != null) {
//                String photoUrl = firebaseUser.getPhotoUrl().toString();
//            }
//        }

    }

    private void dataHandler() {
        String stEmail = edEmail.getText().toString();
        String stPassword = edPassword.getText().toString();
        String stUsername = edUsername.getText().toString();
        createAcount(stEmail, stPassword);
    }

    private void createAcount(String email, String passw) {
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUp.this, "Successful", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(SignUp.this, "Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }


    @Override
    public void onClick(View view) {
            dataHandler();
        }
    }



