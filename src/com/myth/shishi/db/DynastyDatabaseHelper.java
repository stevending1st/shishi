package com.myth.shishi.db;

import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DynastyDatabaseHelper
{
    private static String TABLE_NAME = "t_dynasty";

    public static String[] dynastyArray = {"全部朝代", "先秦", "汉朝", "魏晋", "南北朝", "唐朝", "北宋", "南宋", "元秦", "明朝", "清秦", "近代",
            "当代"};

    public static ArrayList<String> getAll()
    {
        SQLiteDatabase db = DBManager.getDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " order by d_num", null);

        return getDynastyListFromCursor(cursor);
    }

    private static ArrayList<String> getDynastyListFromCursor(Cursor cursor)
    {

        ArrayList<String> list = new ArrayList<String>();
        while (cursor.moveToNext())
        {
            list.add(cursor.getString(cursor.getColumnIndex("d_dynasty")));
        }
        return list;
    }

}
