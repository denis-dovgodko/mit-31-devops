package com.testapp.testapp.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private static Client client = null;
    private static Visit visit = null;
    private static final List<Visit> visitList = new ArrayList<>();

    @BeforeAll
    static void setUp() {
        client = new Client("Ivan");
        Doctor doctor = new Doctor("Ivanovich", List.of("Surgery"),
                List.of(new Procedure("Resection",10)),
                List.of(4, 6));
        visit = new Visit(LocalTime.of(10,0),LocalTime.of(10,20),
                doctor, doctor.getProcedures().get(0),DayOfWeek.of(4));
    }

    @org.junit.jupiter.api.Test
    void testSetGetFullName() {
        client.setFullName("Andriy");
        assertEquals("Andriy", client.getFullName());
    }

    @org.junit.jupiter.api.Test
    void testSetGetVisitList() {
        visitList.add(visit);
        client.setVisitList(visitList);
        assertEquals(visitList, client.getVisitList());
    }

    @org.junit.jupiter.api.Test
    void testAddVisit() {
        visitList.add(visit);
        client.addVisit(visit);
        assertEquals(visitList, client.getVisitList());
    }
}