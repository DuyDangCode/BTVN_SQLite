package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private SQLiteHelper sqLiteHelper;
    private TextView username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        sqLiteHelper = new SQLiteHelper(this);

        if (sqLiteHelper.insertUser("Admin", "123")) {
            Log.i("Success", "Create user");
        } else {
            Log.i("Fail", "Create user");
        }

        for (int i = 0; i <= 9; i++) {
            String name = "Class 00" + i;
            if (sqLiteHelper.insertClass(String.valueOf(i), name, "10")) {
                {
                    Log.i("Success", "Create class");
                    for (int j = 0; j < 10; j++) {
                        String id = name + " " + String.valueOf(j);
                        if (sqLiteHelper.insertStudent(id, "name", "01/01/2003", String.valueOf(i)))
                            Log.i("Success", "Create student");
                        else
                            Log.i("Fail", "Create student");
                    }
                }
            } else {
                Log.i("Fail", "Create class");
            }
        }


        btn.setOnClickListener(v -> {
            String u = username.getText().toString();
            String p = password.getText().toString();

            if (sqLiteHelper.checkUser(u, p)) {
                Intent inten = new Intent(MainActivity.this, CLasses.class);
                startActivity(inten);
            } else {
                Log.i("Fail", "Login");
            }
        });
    }
}