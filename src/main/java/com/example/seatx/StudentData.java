package com.example.seatx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentData extends AppCompatActivity implements View.OnClickListener {

    public EditText ids, passwords, credits;
    public Button save, back0;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);
        setTitle("Enter Student Data");

        databaseReference = FirebaseDatabase.getInstance().getReference("Student");

        ids = findViewById(R.id.idS);
        passwords = findViewById(R.id.passwordS);
        credits = findViewById(R.id.creditS);
        save = findViewById(R.id.save);
        back0 = findViewById(R.id.back0);
        back0.setOnClickListener(this::onBack);

        save.setOnClickListener(this);
    }

    private void onBack(View view) {
        Intent admin = new Intent(this, AdminPanel.class);
        startActivity(admin);
    }

    @Override
    public void onClick(View v) {
        String idS = ids.getText().toString();
        String passwordS = passwords.getText().toString();
        String creditS = credits.getText().toString();
        String busInS = "";
        String busOutS = "";

        Student student = new Student(idS, passwordS, creditS, busInS, busOutS);

        databaseReference.child(idS).setValue(student);
        Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_SHORT).show();
    }
}