package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ClassDetail extends AppCompatActivity {

    List<StudentModel> l = new ArrayList<>();
    TextView id, name, num;
    RecyclerView detail_class_recyccler_view;
    SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);
        detail_class_recyccler_view = findViewById(R.id.detail_class_recyccler_view);
        id = findViewById(R.id.id_class);
        name = findViewById(R.id.name_class);
        num = findViewById(R.id.number_class);
        Intent intent = getIntent();
        id.setText(intent.getStringExtra("id_class"));
        name.setText(intent.getStringExtra("name_class"));
        num.setText(intent.getStringExtra("number_class"));

        sqLiteHelper = new SQLiteHelper(this);
        Cursor cursor = sqLiteHelper.getAllStudentInClass(intent.getStringExtra("id_class"));
        while (cursor.moveToNext()){
            l.add(new StudentModel(cursor.getString(0),cursor.getString(1), cursor.getString(2)));
        }








        detail_class_recyccler_view.setLayoutManager(new LinearLayoutManager(this));
        detail_class_recyccler_view.setAdapter(new StudentsAdapter(getApplicationContext(), l));



    }
}