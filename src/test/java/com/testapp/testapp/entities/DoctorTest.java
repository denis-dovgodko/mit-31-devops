package com.testapp.testapp.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.print.Doc;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    private static Doctor doctor = null;

    @BeforeAll
    static void setUp() {
       doctor = new Doctor("Omelchenko O.I", List.of("Surgery"),
                List.of(new Procedure("Resection", 10)),
                List.of(4, 6));
    }

    @Test
    void testGetFullName() {
        assertEquals("Omelchenko O.I", doctor.getFullName());
    }

    @Test
    void testGetProcedures() {
        assertInstanceOf(Procedure.class, doctor.getProcedures().get(0));
    }

    @Test
    void testGetSetWorking_days() {
        doctor.setWorking_days(List.of(1,6));
        assertEquals(List.of(DayOfWeek.of(1), DayOfWeek.of(6)), doctor.getWorking_days());
    }

    @Test
    void testExceptionsSetWorking_days() {
        assertThrows(DateTimeException.class, () -> doctor.setWorking_days(List.of(8,9)));
    }

    @Test
    void testToString() {
        assertEquals("Omelchenko O.I | [Surgery] | [Resection] | [THURSDAY, SATURDAY]", doctor.toString());
    }
}