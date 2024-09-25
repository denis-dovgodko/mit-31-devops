package com.testapp.testapp.entities;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Visit {
    private LocalTime visitBegin;
    private LocalTime visitEnd;
    private Doctor doctor;
    private Client client;
    private Procedure procedure;
    private final DayOfWeek dayOfWeek;
    private boolean booked;

    public Visit(LocalTime visitBegin, LocalTime visitEnd, Doctor doctor, Procedure procedure, DayOfWeek dayOfWeek) {
        this.visitBegin = visitBegin;
        this.visitEnd = visitEnd;
        this.doctor = doctor;
        this.procedure = procedure;
        this.dayOfWeek = dayOfWeek;
        this.client = null;
        this.booked = false;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public boolean isBooked() {
        return booked;
    }
    public void bookVisit(Client client) {
        this.client = client;
        this.booked = true;
    }
    public void cancelBooking() {
        this.client = null;
        this.booked = false;
    }

    @Override
    public String toString() {
        return visitBegin + " - " + visitEnd;
    }
    public Client getClient() {
        return client;
    }

//    public LocalTime getVisitBegin() {
//        return visitBegin;
//    }
//
//    public void setVisitBegin(LocalTime visitBegin) {
//        this.visitBegin = visitBegin;
//    }
//
//    public LocalTime getVisitEnd() {
//        return visitEnd;
//    }
//
//    public void setVisitEnd(LocalTime visitEnd) {
//        this.visitEnd = visitEnd;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
//
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
//
//    public void setProcedure(Procedure procedure) {
//        this.procedure = procedure;
//    }
//
//    public void setBooked(boolean booked) {
//        this.booked = booked;
//    }
}
