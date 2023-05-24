package com.example.sqlite;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentsViewHolder extends RecyclerView.ViewHolder {

    TextView id_student;
    TextView name_student;
    TextView dob_student;


    public StudentsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.id_student = itemView.findViewById(R.id.id_student);
        this.name_student = itemView.findViewById(R.id.name_student);
        this.dob_student = itemView.findViewById(R.id.dob_student);
    }
}
