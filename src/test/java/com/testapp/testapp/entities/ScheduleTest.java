package com.testapp.testapp.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {
    private static Schedule schedule = null;
    private static final List<Visit> visitList = new ArrayList<>();
    private static Visit firstVisit, secondVisit = null;
    private static Doctor doctor = null;

    @BeforeAll
    static void setUp() {
        schedule = new Schedule(2);
        doctor = new Doctor("Omelchenko A.I", List.of("Surgery"),
                List.of(new Procedure("Resection",10)),
                List.of(3, 6));
        firstVisit = new Visit(LocalTime.of(10,0),LocalTime.of(10,20),
                doctor, doctor.getProcedures().get(0),DayOfWeek.of(3));
        visitList.add(firstVisit);
    }

    @Test
    void testSetWorkingDay() {
        schedule.setWorkingDay(3);
        assertNotEquals(DayOfWeek.of(2), schedule.getWorkingDay());
    }

    @Test
    void testSetGetVisits() {
        secondVisit = new Visit(LocalTime.of(10,30),LocalTime.of(10,50),
                doctor, doctor.getProcedures().get(0),DayOfWeek.of(3));
        visitList.add(secondVisit);
        schedule.setVisits(visitList);
        assertArrayEquals(visitList.toArray(), schedule.getVisits().toArray());
    }

    @Test
    void testAddVisits() {
        List<Visit> visits = new ArrayList<>(schedule.getVisits());
        schedule.addVisits(doctor, 3);
        assertNotEquals(visits, schedule.getVisits());
    }

    @Test
    void testGetDesiredVisits() {
        assertEquals(visitList, (schedule.getDesiredVisits(doctor.getFullName(), 3, doctor.getProcedures().get(0))));
    }
}