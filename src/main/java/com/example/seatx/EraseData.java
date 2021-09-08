package com.example.seatx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EraseData extends AppCompatActivity implements View.OnClickListener {
    Button deleted, back0;
    DatabaseReference studentDATA, seatInData, seatOutData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erase_data);
        setTitle("Erase Data");

        deleted = findViewById(R.id.deleted);
        deleted.setOnClickListener(this);
        back0 = findViewById(R.id.back0);
        back0.setOnClickListener(this::onBack);
    }

    private void onBack(View view) {
        Intent admin = new Intent(this, AdminPanel.class);
        startActivity(admin);
    }

    @Override
    public void onClick(View v) {
        studentDATA = FirebaseDatabase.getInstance().getReference("Student");
        seatInData = FirebaseDatabase.getInstance().getReference("SeatIn");
        seatOutData = FirebaseDatabase.getInstance().getReference("SeatOut");

        studentDATA.child("17000000").child("seatIn").setValue("");
        studentDATA.child("17000000").child("seatOut").setValue("");

        studentDATA.child("17101010").child("seatIn").setValue("");
        studentDATA.child("17101010").child("seatOut").setValue("");

        studentDATA.child("17101075").child("seatIn").setValue("");
        studentDATA.child("17101075").child("seatOut").setValue("");

        studentDATA.child("a").child("seatIn").setValue("");
        studentDATA.child("a").child("seatOut").setValue("");

        studentDATA.child("b").child("seatIn").setValue("");
        studentDATA.child("b").child("seatOut").setValue("");

        studentDATA.child("c").child("seatIn").setValue("");
        studentDATA.child("c").child("seatOut").setValue("");

        seatInData.child("A1").child("seatStatus").setValue("0");
        seatInData.child("A2").child("seatStatus").setValue("0");
        seatInData.child("A3").child("seatStatus").setValue("0");
        seatInData.child("A4").child("seatStatus").setValue("0");
        seatInData.child("A5").child("seatStatus").setValue("0");
        seatInData.child("A6").child("seatStatus").setValue("0");
        seatInData.child("A7").child("seatStatus").setValue("0");
        seatInData.child("A8").child("seatStatus").setValue("0");

        seatInData.child("B1").child("seatStatus").setValue("0");
        seatInData.child("B2").child("seatStatus").setValue("0");
        seatInData.child("B3").child("seatStatus").setValue("0");
        seatInData.child("B4").child("seatStatus").setValue("0");
        seatInData.child("B5").child("seatStatus").setValue("0");
        seatInData.child("B6").child("seatStatus").setValue("0");
        seatInData.child("B7").child("seatStatus").setValue("0");
        seatInData.child("B8").child("seatStatus").setValue("0");

        seatInData.child("C1").child("seatStatus").setValue("0");
        seatInData.child("C2").child("seatStatus").setValue("0");
        seatInData.child("C3").child("seatStatus").setValue("0");
        seatInData.child("C4").child("seatStatus").setValue("0");
        seatInData.child("C5").child("seatStatus").setValue("0");
        seatInData.child("C6").child("seatStatus").setValue("0");
        seatInData.child("C7").child("seatStatus").setValue("0");
        seatInData.child("C8").child("seatStatus").setValue("0");

        seatInData.child("D1").child("seatStatus").setValue("0");
        seatInData.child("D2").child("seatStatus").setValue("0");
        seatInData.child("D3").child("seatStatus").setValue("0");
        seatInData.child("D4").child("seatStatus").setValue("0");
        seatInData.child("D5").child("seatStatus").setValue("0");
        seatInData.child("D6").child("seatStatus").setValue("0");
        seatInData.child("D7").child("seatStatus").setValue("0");
        seatInData.child("D8").child("seatStatus").setValue("0");

        seatOutData.child("A1").child("seatStatus").setValue("0");
        seatOutData.child("A2").child("seatStatus").setValue("0");
        seatOutData.child("A3").child("seatStatus").setValue("0");
        seatOutData.child("A4").child("seatStatus").setValue("0");
        seatOutData.child("A5").child("seatStatus").setValue("0");
        seatOutData.child("A6").child("seatStatus").setValue("0");
        seatOutData.child("A7").child("seatStatus").setValue("0");
        seatOutData.child("A8").child("seatStatus").setValue("0");

        seatOutData.child("B1").child("seatStatus").setValue("0");
        seatOutData.child("B2").child("seatStatus").setValue("0");
        seatOutData.child("B3").child("seatStatus").setValue("0");
        seatOutData.child("B4").child("seatStatus").setValue("0");
        seatOutData.child("B5").child("seatStatus").setValue("0");
        seatOutData.child("B6").child("seatStatus").setValue("0");
        seatOutData.child("B7").child("seatStatus").setValue("0");
        seatOutData.child("B8").child("seatStatus").setValue("0");

        seatOutData.child("C1").child("seatStatus").setValue("0");
        seatOutData.child("C2").child("seatStatus").setValue("0");
        seatOutData.child("C3").child("seatStatus").setValue("0");
        seatOutData.child("C4").child("seatStatus").setValue("0");
        seatOutData.child("C5").child("seatStatus").setValue("0");
        seatOutData.child("C6").child("seatStatus").setValue("0");
        seatOutData.child("C7").child("seatStatus").setValue("0");
        seatOutData.child("C8").child("seatStatus").setValue("0");

        seatOutData.child("D1").child("seatStatus").setValue("0");
        seatOutData.child("D2").child("seatStatus").setValue("0");
        seatOutData.child("D3").child("seatStatus").setValue("0");
        seatOutData.child("D4").child("seatStatus").setValue("0");
        seatOutData.child("D5").child("seatStatus").setValue("0");
        seatOutData.child("D6").child("seatStatus").setValue("0");
        seatOutData.child("D7").child("seatStatus").setValue("0");
        seatOutData.child("D8").child("seatStatus").setValue("0");
    }
}