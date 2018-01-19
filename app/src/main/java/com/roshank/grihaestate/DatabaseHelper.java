package com.roshank.grihaestate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    static String name = "grihaestate";
    static int version = 1;

    String sqlCreateTableUserInfo = "CREATE TABLE  if not exists`UserInfo` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`title`\tTEXT,\n" +
            "\t`firstname`\tTEXT,\n" +
            "\t`lastname`\tTEXT,\n" +
            "\t`email`\tTEXT,\n" +
            "\t`homephone`\tTEXT,\n" +
            "\t`mobile`\tTEXT,\n" +
            "\t`address`\tTEXT,\n" +
            "\t`username`\tTEXT,\n" +
            "\t`password`\tTEXT\n" +
            ")";

    String sqlCreatePropertyDetailsTable = "CREATE TABLE if not exists `PropertyDetailsTable` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`propertyid`\tTEXT,\n" +
            "\t`type`\tTEXT,\n" +
            "\t`status`\tTEXT,\n" +
            "\t`area`\tTEXT,\n" +
            "\t`rooms`\tTEXT,\n" +
            "\t`beds`\tTEXT,\n" +
            "\t`baths`\tTEXT,\n" +
            "\t`garages`\tTEXT,\n" +
            "\t`overallrating`\tTEXT\n" +
            ")";

    String sqlCreatePropertyImageTable = "CREATE TABLE if not exists`PropertyImagesTable` (\n" +
            "\t`id`\tINTEGER,\n" +
            "\t`propertyid`\tTEXT,\n" +
            "\t`image`\tBLOB\n" +
            ")";

    public DatabaseHelper(Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(sqlCreateTableUserInfo);
        getWritableDatabase().execSQL(sqlCreatePropertyDetailsTable);
        getWritableDatabase().execSQL(sqlCreatePropertyImageTable);
    }

    public void InsertRecord(ContentValues cv) {
        getWritableDatabase().insert("UserInfo", "", cv);
//        getWritableDatabase().insert("PropertyDetailsTable", "", cv);


    }

    public boolean isValidLogin(String username, String password){
        String sql = "select count(*) from UserInfo where username='"+username+"' and password ='"+password+"'";
        SQLiteStatement stm= getWritableDatabase().compileStatement(sql);
        long l = stm.simpleQueryForLong();

        if(l==1){
            return true;
        }return false;
    }


    public ArrayList<UserInfo> getuserList() {
        String sql = "Select * from Records";

        Cursor c = getWritableDatabase().rawQuery(sql, null);

        ArrayList<UserInfo> list = new ArrayList<UserInfo>();

        while (c.moveToNext()) {
            UserInfo info = new UserInfo();
            info.id = c.getString(c.getColumnIndex("id"));
            info.title = c.getString(c.getColumnIndex("title"));
            info.firstname = c.getString(c.getColumnIndex("firstname"));
            info.lastname = c.getString(c.getColumnIndex("lastname"));
            info.email = c.getString(c.getColumnIndex("email"));
            info.homephone = c.getString(c.getColumnIndex("homephone"));
            info.mobile = c.getString(c.getColumnIndex("mobile"));

            info.address = c.getString(c.getColumnIndex("address"));
            info.username = c.getString(c.getColumnIndex("username"));
            info.password = c.getString(c.getColumnIndex("password"));
            info.passwordconfirmation = c.getString(c.getColumnIndex("passwordconfirmation"));
        list.add(info);
        }

        c.close();

        return list;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(sqlCreateTableUserInfo);
        sqLiteDatabase.execSQL(sqlCreatePropertyDetailsTable);
        sqLiteDatabase.execSQL(sqlCreatePropertyImageTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(sqlCreateTableUserInfo);
        sqLiteDatabase.execSQL(sqlCreatePropertyDetailsTable);
        sqLiteDatabase.execSQL(sqlCreatePropertyImageTable);
    }
}
