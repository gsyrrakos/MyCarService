package com.example.mycarservice.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {


    @PrimaryKey(autoGenerate = true)
    private int id;


    public String INCURANCE_PROV;
    public String SERVICE_SHOP;
    public String MILAUGE;
    public String CAR_MAKE;
    public String DATE_FROM;
    public String FAULT_CODES;
    public String KIND_SERVICE;
    public String FIX_FAULT;


    private int priority;

    public int getPriority() {
        return priority;
    }

    public Note(String SERVICE_SHOP, String MILAUGE, String DATE_FROM, String KIND_SERVICE, int priority) {

        this.SERVICE_SHOP = SERVICE_SHOP;
        this.MILAUGE = MILAUGE;

        this.DATE_FROM = DATE_FROM;

        this.KIND_SERVICE = KIND_SERVICE;

        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }


    public String getSERVICE_SHOP() {
        return SERVICE_SHOP;
    }

    public String getMILAUGE() {
        return MILAUGE;
    }


    public String getDATE_FROM() {
        return DATE_FROM;
    }


    public String getKIND_SERVICE() {
        return KIND_SERVICE;
    }


}
