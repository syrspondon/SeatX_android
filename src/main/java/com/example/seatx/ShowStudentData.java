package com.example.seatx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ShowStudentData extends AppCompatActivity {
    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    public Button back0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student_data);
        setTitle("Student's Data");

        back0 = findViewById(R.id.back0);
        back0.setOnClickListener(this::onBack);

        recyclerView = findViewById(R.id.reView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Student> options =
                new FirebaseRecyclerOptions.Builder<Student>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Student"), Student.class)
                        .build();
        studentAdapter = new StudentAdapter(options);
        recyclerView.setAdapter(studentAdapter);
    }

    private void onBack(View view) {
        Intent admin = new Intent(this, AdminPanel.class);
        startActivity(admin);
    }

    @Override
    protected void onStart() {
        super.onStart();
        studentAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        studentAdapter.stopListening();
    }
}