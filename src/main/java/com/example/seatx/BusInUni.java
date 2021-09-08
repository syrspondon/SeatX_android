package com.example.seatx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class BusInUni extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    public Spinner spinner;
    public Button selectButton, backIn;
    public int x;
    public String seatNo, id, credit, seatIn, seatOut;
    public ArrayList<String> seatS = new ArrayList<String>();
    DatabaseReference referenceSeat, referenceStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_in_uni);
        setTitle("Seat booking for In Uni");

        Intent dataFromStudent = getIntent();
        id = dataFromStudent.getStringExtra("id");
        credit = dataFromStudent.getStringExtra("credit");
        seatIn = dataFromStudent.getStringExtra("seatIn");
        seatOut = dataFromStudent.getStringExtra("seatOut");
        seatS = dataFromStudent.getStringArrayListExtra("arraySeat");
        Log.v("LOL","arrayList "+seatS);

        x = Integer.parseInt(credit);
        x = x-1;

        spinner = findViewById(R.id.spinner);
        selectButton = findViewById(R.id.seatButton);
        backIn = findViewById(R.id.backIn);

        referenceStudent = FirebaseDatabase.getInstance().getReference("Student");
        referenceSeat = FirebaseDatabase.getInstance().getReference("SeatIn");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, seatS);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Log.v("LOL","adapter "+ myAdapter.getCount());

        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(this);

        selectButton.setOnClickListener(this::onClick);
        backIn.setOnClickListener(this::back);
    }

    private void back(View view) {
        Intent out = new Intent(this, StudentBusS.class);
        out.putExtra("id", id);
        out.putExtra("credit", credit);
        out.putExtra("seatIn", seatIn);
        out.putExtra("seatOut", seatOut);
        startActivity(out);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.v("LOL","position "+position);
        seatNo = seatS.get(position);
        Log.v("LOL","seat "+seatNo);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onClick(View v) {
        credit = ""+x;
        referenceSeat.child(seatNo).child("seatStatus").setValue("1");
        referenceStudent.child(id).child("seatIn").setValue(seatNo);
        referenceStudent.child(id).child("credit").setValue(credit);
        seatIn = seatNo;
        Toast.makeText(getApplicationContext(),"Seat number "+seatNo+" is booked",Toast.LENGTH_SHORT).show();
        Intent out = new Intent(this, StudentBusS.class);
        out.putExtra("id", id);
        out.putExtra("credit", credit);
        out.putExtra("seatIn", seatIn);
        out.putExtra("seatOut", seatOut);
        startActivity(out);
    }
}