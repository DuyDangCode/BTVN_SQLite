package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String dbName = "Btvn.db";

    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public SQLiteHelper(@Nullable Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table users(username TEXT primary key, password TEXT)");
        sqLiteDatabase.execSQL("create Table classes(id TEXT primary key, name TEXT, num TEXT)");
        sqLiteDatabase.execSQL("create Table students(id TEXT primary key, name TEXT, dob TEXT, idClass TEXT, FOREIGN KEY (idClass) REFERENCES classes(id))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists users");
        sqLiteDatabase.execSQL("drop Table if exists classes");
        sqLiteDatabase.execSQL("drop Table if exists students");

    }

    public Boolean insertUser(String username, String password){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("username", username);
        content.put("password", password);
        long result = database.insert("users", null, content);
        if(result == -1)
            return false;
        return true;
    }

    public Boolean insertClass(String id, String name, String num){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("id", id);
        content.put("name", name);
        content.put("num", num);
        long result = database.insert("classes", null, content);
        if(result == -1)
            return false;
        return true;
    }

    public Boolean insertStudent(String id, String name, String dob, String idClass){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("id", id);
        content.put("name", name);
        content.put("dob", dob);
        content.put("idClass", idClass);
        long result = database.insert("students", null, content);
        if(result == -1)
            return false;
        return true;
    }

    public Boolean checkUser(String username, String password){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from users where username = ? and password = ?", new String[]{username, password});
        if(cursor.getCount() > 0){
            return true;
        }
        return false;
    }

    public Cursor getAllClasses(){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from classes", new String[]{});
        if(cursor.getCount()>0)
            Log.i("Success", "getAllClasses");
        else
            Log.i("Fail", "getAllClasses");
        return cursor;
    }

    public Cursor getAllStudentInClass(String id){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from students where idClass = ?", new String[]{id});
        if(cursor.getCount()>0)
            Log.i("Success", "getAllStudentInClass");
        else
            Log.i("Fail", "getAllStudentInClass");
        return cursor;
    }
}
