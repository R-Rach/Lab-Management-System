package com.hellospringdemo.model;

import javax.persistence.*;

@Entity
public class _6018
{
    @Id
    @Column(name = "DATE", nullable = true)
    String Date;
    String Lab_Name_And_Time;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLab_Name_And_Time() {
        return Lab_Name_And_Time;
    }

    public void setLab_Name_And_Time(String lab_Name_And_Time) {
        Lab_Name_And_Time = lab_Name_And_Time;
    }
}
