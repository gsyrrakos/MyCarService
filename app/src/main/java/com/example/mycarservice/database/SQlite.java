package com.example.mycarservice.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQlite extends SQLiteOpenHelper {
    public static final String MYCAR_DB = "MYCAR_DB";
    public static final String INCURANCE_PROV = "INCURANCE_PROV";
    public static final String SERVICE_SHOP = "SERVICE_SHOP";
    public static final String MILAUGE = "MILAUGE";
    public static final String CAR_MAKE = "CAR_MAKE";
    public static final String DATE_FROM = "DATE_FROM";
    public static final String FAULT_CODES = "FAULT_CODES";
    public static final String KIND_SERVICE = "KIND_SERVICE";
    public static final String FIX_FAULT = "FIX_FAULT";

    public SQlite(@Nullable Context context) {
        super(context, "MycarDb", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + MYCAR_DB + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + CAR_MAKE + "," + MILAUGE + "," + SERVICE_SHOP + "" +
                "," + INCURANCE_PROV + "," + DATE_FROM + ",DATE_TO," + FAULT_CODES + "," + KIND_SERVICE + "," + FIX_FAULT + ")";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {




    }

    public boolean addone(){



        return true;

    }



}
