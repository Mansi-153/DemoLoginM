package com.example.demologin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Admin";
    public static final String TABLE_NAME = "Admin_Record";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Department";
    public static final String COL_4 = "Password";


    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Department TEXT,Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String id, String name,String department,String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(COL_1, id);
        content.put(COL_2, name);
        content.put(COL_3, department);
        content.put(COL_4, Password);
        long result = db.insert(TABLE_NAME, null, content);
        return result != -1;
    }
    public Cursor viewAll(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from "+TABLE_NAME+" Where "+COL_1+" = "+id, null);
        return res;
    }
    public Cursor viewAll1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from "+TABLE_NAME, null);
        return res;
    }
    public boolean updateAll(String id, String name ,String surname, String Password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(COL_1, id);
        content.put(COL_2, name);
        content.put(COL_3, surname);
        content.put(COL_4, Password);
        db.update(TABLE_NAME,content ,"ID = ?" , new String[] { id });
        return true;

    }
    public Integer deleteAll(String id){

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }

}
