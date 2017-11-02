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
        etName=(EditText)findViewById(R.id.etPrice);
        etAmount=(EditText)findViewById(R.id.etName);
        etPrice=(EditText)findViewById(R.id.etAmount);
        btnSave=(Button) findViewById(R.id.btnSave);
        BtnImage=(ImageButton) findViewById(R.id.BtnImage);

    }
    public void dataHandler(){
        String name=etName.getText().toString();
        String stAmount= etAmount.getText().toString();
        String stUnits=etUnits.getText().toString();
        String stPrice=etPrice.getText().toString();
        double amount=Double.parseDouble(stAmount);
        double price=Double.parseDouble(stPrice);
    }

    @Override
    public void onClick(View view) {
        if(btnSave==view){





        }
    }
}
