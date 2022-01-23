package com.hellospringdemo.model;

import javax.persistence.*;


@Entity
public class LabDetail {

    @Id
    @Column(name = "LAB_NUMBER", nullable = true)
    String Lab_Number;
    String Lab_Name;
    String Number_Of_Systems;
    String Ram;
    String Processor;
    String Softwares;

    public String getLab_Number() {
        return Lab_Number;
    }

    public void setLab_Number(String lab_Number) {
        Lab_Number = lab_Number;
    }

    public String getLab_Name() {
        return Lab_Name;
    }

    public void setLab_Name(String lab_Name) {
        Lab_Name = lab_Name;
    }

    public String getNumber_Of_Systems() {
        return Number_Of_Systems;
    }

    public void setNumber_Of_Systems(String number_Of_Systems) {
        Number_Of_Systems = number_Of_Systems;
    }

    public String getRam() {
        return Ram;
    }

    public void setRam(String ram) {
        Ram = ram;
    }

    public String getProcessor() {
        return Processor;
    }

    public void setProcessor(String processor) {
        Processor = processor;
    }

    public String getSoftwares() {
        return Softwares;
    }

    public void setSoftwares(String softwares) {
        Softwares = softwares;
    }
}
