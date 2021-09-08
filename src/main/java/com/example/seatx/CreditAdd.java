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

public class CreditAdd extends AppCompatActivity implements View.OnClickListener {
    EditText idC, creditA;
    Button add, back0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_add);
        setTitle("Credit Add");

        idC = findViewById(R.id.idCredit);
        creditA = findViewById(R.id.creditAdd);
        add = findViewById(R.id.addC);
        back0 = findViewById(R.id.back0);

        add.setOnClickListener(this);
        back0.setOnClickListener(this::onBack);
    }

    private void onBack(View view) {
        Intent admin = new Intent(this, AdminPanel.class);
        startActivity(admin);
    }

    @Override
    public void onClick(View v) {
        final String userEnteredUsername = idC.getText().toString().trim();
        final String userEnteredCredit = creditA.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Student");
        Query checkUser = reference.orderByChild("id").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    idC.setError(null);
                    String x = dataSnapshot.child(userEnteredUsername).child("credit").getValue(String.class);
                    int y = Integer.parseInt(x);
                    int z = Integer.parseInt(userEnteredCredit);
                    int t = y+z;
                    x = ""+t;
                    reference.child(userEnteredUsername).child("credit").setValue(x);
                } else {
                    idC.setError("No such Id exist");
                    idC.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}