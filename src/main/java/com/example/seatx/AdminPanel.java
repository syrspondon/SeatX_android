package com.example.seatx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPanel extends AppCompatActivity implements View.OnClickListener {
    Button StudentAdd, seatAdd, adminADD, creditADD, showStudentData, logOUT, erase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        setTitle("Admin Panel");

        StudentAdd = findViewById(R.id.studentAdd);
        seatAdd = findViewById(R.id.seatadd);
        adminADD = findViewById(R.id.adminADD);
        creditADD = findViewById(R.id.creditadd);
        showStudentData = findViewById(R.id.showStudentData);
        logOUT = findViewById(R.id.logOUT);
        erase = findViewById(R.id.erase);

        StudentAdd.setOnClickListener(this::onClick);
        seatAdd.setOnClickListener(this::onClick2);
        adminADD.setOnClickListener(this::onClick3);
        creditADD.setOnClickListener(this::onClick4);
        showStudentData.setOnClickListener(this::onClick5);
        logOUT.setOnClickListener(this::logOut);
        erase.setOnClickListener(this::erase);
    }

    @Override
    public void onClick(View v) {
        Intent admin = new Intent(this, StudentData.class);
        startActivity(admin);
    }

    public void onClick2(View v2){
        Intent admin = new Intent(this, SeatAdd.class);
        startActivity(admin);
    }

    public void onClick3(View v3) {
        Intent admin = new Intent(this, AdminDarta.class);
        startActivity(admin);
    }

    public void onClick4(View v4) {
        Intent admin = new Intent(this, CreditAdd.class);
        startActivity(admin);
    }

    public void onClick5(View v5) {
        Intent admin = new Intent(this, ShowStudentData.class);
        startActivity(admin);
    }

    private void logOut(View v6) {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }

    private void erase(View v7) {
        Intent admin = new Intent(this, EraseData.class);
        startActivity(admin);
    }
}