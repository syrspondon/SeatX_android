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

public class AdminLogIn extends AppCompatActivity implements View.OnClickListener {
    EditText id, pass;
    Button login, backM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_log_in);
        setTitle("Admin Log In");

        id = findViewById(R.id.adminID);
        pass = findViewById(R.id.adminPASS);
        login = findViewById(R.id.adminLOG);
        backM = findViewById(R.id.backM);

        login.setOnClickListener(this);
        backM.setOnClickListener(this::onClick2);
    }

    @Override
    public void onClick(View v) {
        final String userEnteredUsername = id.getText().toString().trim();
        final String userEnteredPassword = pass.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Admin");
        Query checkUser = reference.orderByChild("id").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    id.setError(null);
                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)) {
                        id.setError(null);
                        Intent toStudentBus = new Intent(getApplicationContext(), AdminPanel.class);
                        startActivity(toStudentBus);
                    } else {
                        pass.setError("Wrong Password");
                        pass.requestFocus();
                    }
                } else {
                    id.setError("No such Id exist");
                    id.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void onClick2(View view) {
        Intent mainP = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainP);
    }
}