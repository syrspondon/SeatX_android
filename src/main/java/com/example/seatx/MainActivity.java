package com.example.seatx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText id, pass;
    Button login, admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.id);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.log);
        admin = findViewById(R.id.admin);

        admin.setOnClickListener(this);
        login.setOnClickListener(this::toLogin);
    }

    private void toLogin(View view) {
        final String userEnteredUsername = id.getText().toString().trim();
        final String userEnteredPassword = pass.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Student");
        Query checkUser = reference.orderByChild("id").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    id.setError(null);
                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)) {
                        id.setError(null);
                        String idFromDB = dataSnapshot.child(userEnteredUsername).child("id").getValue(String.class);
                        String creditFromDB = dataSnapshot.child(userEnteredUsername).child("credit").getValue(String.class);
                        String seatInFromDB = dataSnapshot.child(userEnteredUsername).child("seatIn").getValue(String.class);
                        String seatOutFromDB = dataSnapshot.child(userEnteredUsername).child("seatOut").getValue(String.class);
                        Intent toStudentBus = new Intent(getApplicationContext(), StudentBusS.class);
                        toStudentBus.putExtra("id", idFromDB);
                        toStudentBus.putExtra("credit", creditFromDB);
                        toStudentBus.putExtra("seatIn", seatInFromDB);
                        toStudentBus.putExtra("seatOut", seatOutFromDB);
                        startActivity(toStudentBus);
                    } else {
                        pass.setError("Wrong Password");
                        pass.requestFocus();
                    }
                } else {
                    id.setError("No such User exist");
                    id.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent admin = new Intent(this, AdminLogIn.class);
        startActivity(admin);
    }
}