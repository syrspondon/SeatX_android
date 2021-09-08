package com.example.seatx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentBusS extends AppCompatActivity implements View.OnClickListener {

    public TextView busIn, busOut, busData;
    public Button bIn, bOut, logOut;
    public String id, credit, seatIn, seatOut;
    public int credits;
    public ArrayList<String> seatSIn = new ArrayList<String>();
    public ArrayList<String> seatSOut = new ArrayList<String>();
    DatabaseReference referenceSeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_bus_s);
        setTitle("Seat Book");

        Intent dataFromStudent = getIntent();
        id = dataFromStudent.getStringExtra("id");
        credit = dataFromStudent.getStringExtra("credit");
        seatIn = dataFromStudent.getStringExtra("seatIn");
        seatOut = dataFromStudent.getStringExtra("seatOut");

        if (seatIn.isEmpty())
            seatIn = "No booking";
        if (seatOut.isEmpty())
            seatOut = "No booking";

        String dataS = "ID: "+id+"\nCredits left: "+credit+"\nBooked seat for In: "+seatIn+"\nBooked seat for Out: "+seatOut;

        credits = Integer.parseInt(credit);

        referenceSeat = FirebaseDatabase.getInstance().getReference("SeatIn");
        referenceSeat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()){
                    BusDataAdd bus = new BusDataAdd();
                    bus.setSeatNumber(ds.getValue(BusDataAdd.class).getSeatNumber());
                    bus.setSeatStatus(ds.getValue(BusDataAdd.class).getSeatStatus());
                    if (bus.getSeatStatus().equals("0"))
                        seatSIn.add(bus.getSeatNumber());
                }
                Log.v("LOL","list 1 "+seatSIn);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        referenceSeat = FirebaseDatabase.getInstance().getReference("SeatOut");
        referenceSeat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()){
                    BusDataAdd bus = new BusDataAdd();
                    bus.setSeatNumber(ds.getValue(BusDataAdd.class).getSeatNumber());
                    bus.setSeatStatus(ds.getValue(BusDataAdd.class).getSeatStatus());
                    if (bus.getSeatStatus().equals("0"))
                        seatSOut.add(bus.getSeatNumber());
                }
                Log.v("LOL","list 1 "+seatSOut);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        busIn = findViewById(R.id.inData);
        busOut = findViewById(R.id.outData);
        busData = findViewById(R.id.busdata);
        bIn = findViewById(R.id.busIn);
        bOut = findViewById(R.id.busOut);
        logOut = findViewById(R.id.logOut);

        busData.setText(dataS);

        if (credits>0) {
            bIn.setOnClickListener(this::onBusIn);
            bOut.setOnClickListener(this::onBusOut);
        }
        else
            Toast.makeText(getApplicationContext(),"Insufficient credit",Toast.LENGTH_SHORT).show();
        logOut.setOnClickListener(this::logOut);
    }

    public void onBusIn(View v1) {
        if (credits>0){
            if (seatIn.equals("No booking")) {
                Intent in = new Intent(this, BusInUni.class);
                in.putExtra("id", id);
                in.putExtra("credit", credit);
                in.putExtra("seatIn", seatIn);
                in.putExtra("seatOut", seatOut);
                in.putExtra("arraySeat",seatSIn);
                startActivity(in);
            }
            else
                Toast.makeText(getApplicationContext(),"Seat is already booked",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"Insufficient credit",Toast.LENGTH_SHORT).show();
    }
    public void onBusOut(View v2) {
        if (credits>0){
            if (seatOut.equals("No booking")) {
                Intent out = new Intent(this, BusOutUni.class);
                out.putExtra("id", id);
                out.putExtra("credit", credit);
                out.putExtra("seatIn", seatIn);
                out.putExtra("seatOut", seatOut);
                out.putExtra("arraySeat",seatSOut);
                startActivity(out);
            }
            else
                Toast.makeText(getApplicationContext(),"Seat is already booked",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"Insufficient credit",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
    }
    private void logOut(View view) {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }
}