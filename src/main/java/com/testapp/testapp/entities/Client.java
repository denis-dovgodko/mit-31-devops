package com.testapp.testapp.entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String fullName;
    private List<Visit> visitList;

    public Client(String fullName) {
        this.fullName = fullName;
        this.visitList = new ArrayList<>();
    }
    public void addVisit(Visit visit){
        List<Visit> visits= getVisitList();
        getVisitList().add(visit);
        this.visitList = visits;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }
}
