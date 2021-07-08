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
        return priority;}

    public Note(String INCURANCE_PROV, String SERVICE_SHOP, String MILAUGE, String CAR_MAKE, String DATE_FROM, String FAULT_CODES, String KIND_SERVICE, String FIX_FAULT,int priority) {
        this.INCURANCE_PROV = INCURANCE_PROV;
        this.SERVICE_SHOP = SERVICE_SHOP;
        this.MILAUGE = MILAUGE;
        this.CAR_MAKE = CAR_MAKE;
        this.DATE_FROM = DATE_FROM;
        this.FAULT_CODES = FAULT_CODES;
        this.KIND_SERVICE = KIND_SERVICE;
        this.FIX_FAULT = FIX_FAULT;
        this.priority=priority;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }
    public String getINCURANCE_PROV() {
        return INCURANCE_PROV;
    }

    public String getSERVICE_SHOP() {
        return SERVICE_SHOP;
    }

    public String getMILAUGE() {
        return MILAUGE;
    }

    public String getCAR_MAKE() {
        return CAR_MAKE;
    }

    public String getDATE_FROM() {
        return DATE_FROM;
    }

    public String getFAULT_CODES() {
        return FAULT_CODES;
    }

    public String getKIND_SERVICE() {
        return KIND_SERVICE;
    }

    public String getFIX_FAULT() {
        return FIX_FAULT;
    }
}
