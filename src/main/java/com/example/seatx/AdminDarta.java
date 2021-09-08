package com.example.seatx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminDarta extends AppCompatActivity implements View.OnClickListener {

    public EditText idA, passwordA;
    public Button saveA, back0;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_darta);
        setTitle("Enter Admin Data");

        databaseReference = FirebaseDatabase.getInstance().getReference("Admin");

        idA = findViewById(R.id.adminId);
        passwordA = findViewById(R.id.adminPass);
        saveA = findViewById(R.id.adminAdd);
        back0 = findViewById(R.id.back0);

        back0.setOnClickListener(this::onBack);
        saveA.setOnClickListener(this);
    }

    private void onBack(View view) {
        Intent admin = new Intent(this, AdminPanel.class);
        startActivity(admin);
    }

    @Override
    public void onClick(View v) {
        String idAA = idA.getText().toString();
        String passwordAA = passwordA.getText().toString();

        Admin admin = new Admin(idAA, passwordAA);
        databaseReference.child(idAA).setValue(admin);
    }
}