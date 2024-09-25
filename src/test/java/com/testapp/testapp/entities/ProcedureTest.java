package com.testapp.testapp.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcedureTest {
    private static Procedure procedure = null;

    @BeforeAll
    static void setUp() {
        procedure = new Procedure("Resection", 10);
    }

    @Test
    void testGetDurationTimeMinutes() {
        assertEquals(10, procedure.getDurationTimeMinutes());
    }

    @Test
    void testSetProcedureAndToString() {
        procedure.setProcedureName("Stitches removing");
        assertNotEquals("Resection", procedure.toString());
    }
}