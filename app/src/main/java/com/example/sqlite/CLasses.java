package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CLasses extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        recyclerView = findViewById(R.id.classes_recycler_view);
        sqLiteHelper = new SQLiteHelper(this);

        List<ClassModel> l = new ArrayList<>();
        Cursor cursor = sqLiteHelper.getAllClasses();
        while(cursor.moveToNext()){
            l.add(new ClassModel(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ClassesAdapter(getApplicationContext(), l));

    }
}