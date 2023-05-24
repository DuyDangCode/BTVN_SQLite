package com.example.sqlite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClassesAdapter extends RecyclerView.Adapter<ClassesViewHolder> {


    Context context;
    List<ClassModel> l;

    public ClassesAdapter(Context context, List<ClassModel> l) {
        this.context = context;
        this.l = l;
    }

    @NonNull
    @Override
    public ClassesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ClassesViewHolder(LayoutInflater.from(context).inflate(R.layout.class_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClassesViewHolder holder, int position) {
        holder.id.setText(l.get(position).getId());
        holder.name.setText(l.get(position).getName());
        holder.number.setText(l.get(position).getNum());

        holder.itemView.setOnClickListener(v->{click(v, position);});


    }

    @Override
    public int getItemCount() {
        return l.size();
    }

    public void click(View v, int p){
        Intent intent = new Intent(v.getContext(),ClassDetail.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("id_class", l.get(p).getId());
        intent.putExtra("name_class", l.get(p).getName());
        intent.putExtra("number_class", l.get(p).getNum());
        v.getContext().startActivity(intent);
    }
}
