package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsViewHolder> {

    Context context;
    List<StudentModel> l;

    public StudentsAdapter(Context context, List<StudentModel> l) {
        this.context = context;
        this.l = l;
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         return new StudentsViewHolder(LayoutInflater.from(context).inflate(R.layout.student_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {
        holder.id_student.setText(l.get(position).getId());
        holder.name_student.setText(l.get(position).getName());
        holder.dob_student.setText(l.get(position).getDob());

        //holder.itemView.setOnClickListener(v->{click(v);});

    }

    @Override
    public int getItemCount() {
        return l.size();
    }
}
