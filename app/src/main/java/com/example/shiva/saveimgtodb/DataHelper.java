package com.example.shiva.saveimgtodb;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "prajavani";
    public static final String TABLE_NAME = "posts_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "POST_ID";
    public static final String COL_3 = "LINK";
    public static final String COL_4 = "TITLE";
    public static final String COL_5 = "CONTENT";
    public static final String COL_6 = "THUMBNAIL";
    public static final String COL_7 = "IMAGE";
    public static final String COL_8 = "P_DATE";




    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,POST_ID TEXT, LINK TEXT, TITLE TEXT, CONTENT TEXT,THUMBNAIL TEXT,IMAGE TEXT,P_DATE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);

        onCreate(db);

    }

    public boolean insertData(String post_id, String link, String title,String content, String p_date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,post_id);
        contentValues.put(COL_3,link);
        contentValues.put(COL_4,title);
        contentValues.put(COL_5,content);
        contentValues.put(COL_8,p_date);

        Long success = db.insert(TABLE_NAME, null,contentValues);

        if (success == -1){
            return false;
        }else {
            return true;
        }

    }


    public boolean updateImage(String image, String thumbnail, String postId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_6,thumbnail);
        contentValues.put(COL_7,image);

        db.update(TABLE_NAME, contentValues, COL_2+"="+postId, null);
            return true;


    }


    public Cursor getAllData(){
        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }

}
