package com.nutrix.nutrix;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Brian on 7/6/2015.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "FoodInfo.db";
    public static final String TABLE_FOOD = "Food";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_FOODNAME = "foodName";
    private static final String COLUMN_CALORIES = "calories";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_FOOD + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_FOODNAME+ " TEXT " +
                COLUMN_CALORIES + " INTEGER " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);
        onCreate(db);
    }

    //Add new row to database
    public void addFood(Food food) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_FOODNAME, food.get_foodName());
        values.put(COLUMN_CALORIES, food.get_calories());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_FOOD, null, values);
        db.close();
    }

    public void deleteFood(String foodName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_FOOD + " WHERE " + COLUMN_FOODNAME + "=\"" + foodName + "\";");
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_FOOD + " WHERE 1";

        Cursor c = db.rawQuery(query, null);

        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("Login Info")) != null){
                dbString += c.getString(c.getColumnIndex("Login Info"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }

    public boolean authenticate(String username, String password){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + COLUMN_FOODNAME + " FROM " + TABLE_FOOD + " WHERE " + COLUMN_FOODNAME + " = " + username;
        Cursor resultSet = db.rawQuery(query, null);
        return false;
    }
}
