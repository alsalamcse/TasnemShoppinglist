package com.example.user.tasnemshoppinglist;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.user.tasnemshoppinglist.data.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddItemActivity extends AppCompatActivity {
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
        etUnits = (EditText) findViewById(R.id.etUnits);
        etName = (EditText) findViewById(R.id.etName);
        etAmount = (EditText) findViewById(R.id.etAmount);
        etPrice = (EditText) findViewById(R.id.etPrice);
        btnSave = (Button) findViewById(R.id.btnSave);
        BtnImage = (ImageButton) findViewById(R.id.BtnImage);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataHandler();
            }
        });

    }

    public void dataHandler() {
        //1.get data from fields
        String name = etName.getText().toString();
        String stAmount = etAmount.getText().toString();
        String stUnits = etUnits.getText().toString();
        String stPrice = etPrice.getText().toString();
        // 2. todo validate fields input
        //isok=true;...
        //3.data manipolation
        double amount = Double.parseDouble(stAmount);
        double price = Double.parseDouble(stPrice);
        //4. building data object
        Product product = new Product();
        product.setName(name);
        product.setAmount(amount);
        product.setPrice(price);
        product.setCompleted(false);
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

        reference.child(email).child("my list").push().setValue(product)
                //8. add CompleteListener to check if the insertion is done
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(AddItemActivity.this, "add product Succesfull", Toast.LENGTH_SHORT);
                        } else
                            {
                            Toast.makeText(AddItemActivity.this, "add product Failed", Toast.LENGTH_LONG);
                        }

                    }


                });

    }

    }

