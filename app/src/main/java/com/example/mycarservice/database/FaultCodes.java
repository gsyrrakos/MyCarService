package com.example.mycarservice.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_fault")
public class FaultCodes {


    @PrimaryKey(autoGenerate = true)
    private int id;


    public String MILAUGE;

    public String DATE_FROM;
    public String FAULT_CODES;

    public String FIX_FAULT;


    public void setPriority(int priority) {
        this.priority = priority;
    }

    private int priority;

    public FaultCodes() {

    }

    public FaultCodes(String MILAUGE, String DATE_FROM, String FAULT_CODES, String FIX_FAULT, int priority) {

        this.MILAUGE = MILAUGE;
        this.DATE_FROM = DATE_FROM;
        this.FAULT_CODES = FAULT_CODES;
        this.FIX_FAULT = FIX_FAULT;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getMILAUGE() {
        return MILAUGE;
    }

    public String getDATE_FROM() {
        return DATE_FROM;
    }

    public String getFAULT_CODES() {
        return FAULT_CODES;
    }

    public String getFIX_FAULT() {
        return FIX_FAULT;
    }





}
