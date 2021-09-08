package com.example.seatx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SeatAdd extends AppCompatActivity implements View.OnClickListener {
    public Button button, back0;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_add);
        setTitle("Seat Add");

        button = findViewById(R.id.button);

        back0 = findViewById(R.id.back0);
        back0.setOnClickListener(this::onBack);
        //button.setOnClickListener(this);
    }

    private void onBack(View view) {
        Intent admin = new Intent(this, AdminPanel.class);
        startActivity(admin);
    }

    @Override
    public void onClick(View v) {
        String[] seatName = {"A1","A2","A3","A4","A5","A6","A7","A8",
                "B1","B2","B3","B4","B5","B6","B7","B8",
                "C1","C2","C3","C4","C5","C6","C7","C8",
                "D1","D2","D3","D4","D5","D6","D7","D8"};
        String[] seatAv = {"0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0"};


        databaseReference = FirebaseDatabase.getInstance().getReference("||||||");
        for (int i=0; i<32; i++){
            String seatNAME = seatName[i];
            String seatAV = seatAv[i];

            BusDataAdd busDataAdd = new BusDataAdd(seatNAME,seatAV);
            databaseReference.child(seatNAME).setValue(busDataAdd);
        }
        Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_SHORT).show();
    }
}