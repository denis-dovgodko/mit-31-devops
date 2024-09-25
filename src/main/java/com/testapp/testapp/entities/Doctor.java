package com.testapp.testapp.entities;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String fullName;
    private List<String> specialities;
    private List<Procedure> procedures;
    private List<DayOfWeek> working_days;

    public Doctor(String fullName, List<String> specialities, List<Procedure> procedures, List<Integer> working_days) {
        this.fullName = fullName;
        this.specialities = specialities;
        this.procedures = procedures;
        setWorking_days(working_days);
    }

    public String getFullName() {
        return fullName;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public List<DayOfWeek> getWorking_days() {
        return working_days;
    }

    public void setWorking_days(List<Integer> working_days) {
        List<DayOfWeek> working_days_Converted = new ArrayList<>();
        for (Integer day : working_days){
            working_days_Converted.add(DayOfWeek.of(day));
        }
        this.working_days = working_days_Converted;
    }

    @Override
    public String toString() {
        return fullName + " | " + specialities + " | " + procedures + " | " + working_days;
    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public List<String> getSpecialities() {
//        return specialities;
//    }
//
//    public void setSpecialities(List<String> specialities) {
//        this.specialities = specialities;
//    }
//
//    public void setProcedures(List<Procedure> procedures) {
//        this.procedures = procedures;
//    }
}
