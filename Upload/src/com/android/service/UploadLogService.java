package com.android.service;

import java.io.File;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
 
public class UploadLogService {
    private DBOpenHelper dbOpenHelper;
     
    public UploadLogService(Context context){
        this.dbOpenHelper = new DBOpenHelper(context);
    }
     
    public void save(String sourceid, File uploadFile){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("insert into uploadlog(uploadfilepath, sourceid) values(?,?)",
                new Object[]{uploadFile.getAbsolutePath(),sourceid});
    }
     
    public void delete(File uploadFile){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("delete from uploadlog where uploadfilepath=?", new Object[]{uploadFile.getAbsolutePath()});
    }
     
    public String getBindId(File uploadFile){
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select sourceid from uploadlog where uploadfilepath=?", 
                new String[]{uploadFile.getAbsolutePath()});
        if(cursor.moveToFirst()){
        	System.out.println(">>>>>getBindId = " + cursor.getString(0));
            return cursor.getString(0);
        }
        return null;
    }
}
