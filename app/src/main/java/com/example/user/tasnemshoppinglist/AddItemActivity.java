package com.example.user.tasnemshoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddItemActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etUnits;
    private EditText etPrice;
    private EditText etName;
    private EditText etAmount;
    private ImageButton BtnImage;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        etUnits=(EditText)findViewById(R.id.etUnits);
        etUnits=(EditText)findViewById(R.id.etPrice);
        etUnits=(EditText)findViewById(R.id.etName);
        etUnits=(EditText)findViewById(R.id.etAmount);
        btnSave=(Button) findViewById(R.id.btnSave);
        BtnImage=(ImageButton) findViewById(R.id.BtnImage);


    }

    @Override
    public void onClick(View view) {
        if(btnSave==view){


        }
    }
}
