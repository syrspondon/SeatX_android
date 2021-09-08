package com.example.seatx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class StudentAdapter extends FirebaseRecyclerAdapter<Student,StudentAdapter.myViewHolder> {

    public StudentAdapter(@NonNull FirebaseRecyclerOptions<Student> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i, @NonNull Student student) {
        myViewHolder.studentID.setText("Student ID: "+student.getId());
        if (student.getSeatIn().isEmpty())
            myViewHolder.studentSeatIn.setText("No IN seat booked");
        else
            myViewHolder.studentSeatIn.setText("In seat number: "+student.getSeatIn());
        if (student.getSeatOut().isEmpty())
            myViewHolder.studentSeatOut.setText("No Out seat booked");
        else
            myViewHolder.studentSeatOut.setText("Out seat number: "+student.getSeatOut());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        public TextView studentID, studentSeatIn, studentSeatOut;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            studentID = itemView.findViewById(R.id.studentID);
            studentSeatIn = itemView.findViewById(R.id.studentSeatIn);
            studentSeatOut = itemView.findViewById(R.id.studentSeatOut);
        }
    }
}
