package com.android.service;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

   public DBOpenHelper(Context context) {
       super(context, "upload.db", null, 1);
   }

   @Override
   public void onCreate(SQLiteDatabase db) {
       db.execSQL("CREATE TABLE uploadlog (_id integer primary key autoincrement, uploadfilepath varchar(100), sourceid varchar(10))");
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS uploadlog");
       onCreate(db);      
   }

}
