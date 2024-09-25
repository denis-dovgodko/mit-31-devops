package com.testapp.testapp.entities;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private DayOfWeek workingDay;
    private List<Visit> visits;

    public void setWorkingDay(Integer workingDay) {
        this.workingDay = DayOfWeek.of(workingDay);
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public void addVisits(Doctor doctor, Integer dayOfWeek){
        List<Visit> visits = getVisits();
        for (Procedure procedure : doctor.getProcedures()){
            int quantity = 480/procedure.getDurationTimeMinutes();
            LocalTime currentBegin = LocalTime.of(10,0);
            for(int i=0; i < quantity; i++){
                Visit visit = new Visit(currentBegin, currentBegin
                        .plusMinutes(procedure.getDurationTimeMinutes()), doctor, procedure, DayOfWeek.of(dayOfWeek));
                visits.add(visit);
                currentBegin = currentBegin.plusMinutes(procedure.getDurationTimeMinutes());
            }
        }
        setVisits(visits);
    }
    public List<Visit> getDesiredVisits(String doctorName, Integer day, Procedure procedure){
        List<Visit> desiredList = new ArrayList<>();
        for(Visit visit : getVisits()){
            if (visit.getDoctor().getFullName().equals(doctorName)
                    && visit.getDayOfWeek().equals(DayOfWeek.of(day))
                    && visit.getProcedure().equals(procedure)
                    && !visit.isBooked()){
                desiredList.add(visit);
            }
            }
        return desiredList;
        }
    public Schedule(Integer workingDay) {
        setWorkingDay(workingDay);
        this.visits = new ArrayList<>();
    }
    public DayOfWeek getWorkingDay() {
        return workingDay;
    }
}
