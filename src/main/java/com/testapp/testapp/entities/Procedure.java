package com.testapp.testapp.entities;

public class Procedure {
    private String procedureName;
    private Integer durationTimeMinutes;

    public Procedure(String procedureName, Integer durationTimeMinutes) {
        this.procedureName = procedureName;
        this.durationTimeMinutes = durationTimeMinutes;
    }

    public Integer getDurationTimeMinutes() {
        return durationTimeMinutes;
    }

    @Override
    public String toString() {
        return procedureName;
    }
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }
//    public String getProcedureName() {
//        return procedureName;
//    }
//
//
//    public void setDurationTimeMinutes(Integer durationTimeMinutes) {
//        this.durationTimeMinutes = durationTimeMinutes;
//    }
}
