package com.example.labdb53490;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//DatabaseHelper need to extend using SQLiteOpenHelper class
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "prgcheck.db";
    public static final String TABLE_NAME = "books";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "title";
    public static final String COL_3 = "author";
    public static final String COL_4 = "price";

    public DatabaseHelper(Context context) {   // when the constructor is called Database will be created.
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();      // creating the instance of the database- this is going to create your DB and Table.
    }



    @Override
    public void onCreate ( SQLiteDatabase db ) { //to create Table
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, AUTHOR TEXT, PRICE INTERGER) ");
    }

    @Override
    public void onUpgrade ( SQLiteDatabase db, int oldVersion, int newVersion ) {  //Drop the table if exists
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String surname, String marks) {
        SQLiteDatabase db = this.getWritableDatabase();      // creating the instance of the database- this is going to create your DB and Table.
        ContentValues contentValues = new ContentValues();  //import the required classes; now we are taking content values instance
        // and placing the data into the columns.
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

}


//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;

//import androidx.annotation.Nullable;
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//    private static final String DATABASE_NAME = "student.db";
//    private static final int DATABASE_VERSION = 1;
//
//    private static final String CREATE_TABLE =
//            "CREATE TABLE Books (" +
//                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                    "Title TEXT NOT NULL, " +
//                    "Author TEXT  NOT NULL," +
//                    "Price REAL);";
//    public DatabaseHelper(@Nullable Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_TABLE);
//        //db.execSQL("Insert into Grocery (name, cost) values ('Gobi', 40);");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS Books");
//        onCreate(db);
//    }
//}
