package com.example.cleanland.Table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class OrdersTable {
    @PrimaryKey(autoGenerate = true)
    long id;
    @ColumnInfo(name = "shirts")
    public String shirts;
    @ColumnInfo(name = "jackets")
    public String jackets;
    @ColumnInfo(name = "underwares")
    public String underwares;
    @ColumnInfo(name = "panties")
    public String panties;
    @ColumnInfo(name = "suites")
    public String suites;
    @ColumnInfo(name = "others")
    public String others;

    public OrdersTable(String shirts, String jackets, String underwares, String panties, String suites, String others) {
        this.shirts = shirts;
        this.jackets = jackets;
        this.underwares = underwares;
        this.panties = panties;
        this.suites = suites;
        this.others = others;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShirts() {
        return shirts;
    }

    public void setShirts(String shirts) {
        this.shirts = shirts;
    }

    public String getJackets() {
        return jackets;
    }

    public void setJackets(String jackets) {
        this.jackets = jackets;
    }

    public String getUnderwares() {
        return underwares;
    }

    public void setUnderwares(String underwares) {
        this.underwares = underwares;
    }

    public String getPanties() {
        return panties;
    }

    public void setPanties(String panties) {
        this.panties = panties;
    }

    public String getSuites() {
        return suites;
    }

    public void setSuites(String suites) {
        this.suites = suites;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
