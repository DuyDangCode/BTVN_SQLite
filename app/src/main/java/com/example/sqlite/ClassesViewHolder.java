package com.example.sqlite;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClassesViewHolder extends RecyclerView.ViewHolder {
    TextView id;
    TextView name;
    TextView number;

    public ClassesViewHolder(@NonNull View itemView) {
        super(itemView);
        this.id = itemView.findViewById(R.id.id);
        this.name = itemView.findViewById(R.id.name);
        this.number = itemView.findViewById(R.id.number);

    }
}
