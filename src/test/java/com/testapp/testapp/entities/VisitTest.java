package com.testapp.testapp.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VisitTest {
    private static Client client = null;
    private static Doctor doctor = null;
    private static Visit visit = null;
    private static Visit visitToBook = null;

    @BeforeAll
    static void setUp() {
        doctor = new Doctor("Omelchenko A.I", List.of("Surgery"),
                List.of(new Procedure("Resection", 10)),
                List.of(3, 6));
        visit = new Visit(LocalTime.of(10, 0), LocalTime.of(10, 20),
                doctor, doctor.getProcedures().get(0), DayOfWeek.of(3));
        visitToBook = new Visit(LocalTime.of(10, 30), LocalTime.of(10, 50),
                doctor, doctor.getProcedures().get(0), DayOfWeek.of(3));
        client = new Client("Ivanovich");
    }

    @Test
    void testGetDayOfWeek() {
        assertEquals(DayOfWeek.of(3), visit.getDayOfWeek());
    }

    @Test
    void testGetProcedure() {
        assertEquals(doctor.getProcedures().get(0), visit.getProcedure());
    }

    @Test
    void testGetDoctor() {
        assertEquals(doctor, visit.getDoctor());
    }

    @Test
    void testIsBooked() {
        assertFalse(visit.isBooked());
    }

    @Test
    void testBookVisit() {
        visitToBook.bookVisit(client);
        assertEquals(client, visitToBook.getClient());
        assertTrue(visitToBook.isBooked());
    }

    @Test
    void testCancelBooking() {
        visitToBook.bookVisit(client);
        visitToBook.cancelBooking();
        assertFalse(visit.isBooked());
    }

    @Test
    void testToString() {
        assertEquals("10:30 - 10:50", visitToBook.toString());
    }
}