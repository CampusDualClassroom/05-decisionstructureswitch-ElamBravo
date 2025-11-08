package com.campusdual.classroom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp() {
        this.outContent.reset();
        this.errContent.reset();
        System.setOut(new PrintStream(this.outContent));
        System.setErr(new PrintStream(this.errContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(this.originalOut);
        System.setErr(this.originalErr);
    }

    @Test
    @DisplayName("Check hour")
    void testCheckHour() {
        for (int hour = 0; hour < 24; hour++) {
            Exercise.checkHour(hour);
            String expectedMessage;
            if (hour >= 7 && hour < 14) {
                expectedMessage = "It's morning";
            } else if (hour >= 14 && hour < 21) {
                expectedMessage = "It's afternoon";
            } else {
                expectedMessage = "It's night";
            }
            assertTrue(this.outContent.toString().contains(expectedMessage), hour + "h. " + expectedMessage + ", not \"" + this.outContent + "\"");
            this.outContent.reset();
        }
    }

    @Test
    @DisplayName("Check season")
    void testCheckSeason() {
        for (int month = 1; month < 12; month++) {
            Exercise.checkSeason(month);
            String expectedMessage;
            if (month >= 1 && month < 4) {
                expectedMessage = "Winter";
            } else if (month >= 4 && month < 7) {
                expectedMessage = "Spring";
            } else if (month >= 7 && month < 10) {
                expectedMessage = "Summer";
            } else {
                expectedMessage = "Autumn";
            }
            assertTrue(this.outContent.toString().contains(expectedMessage), "Month " + month + " is " + expectedMessage + ", not "+ this.outContent.toString());
            this.outContent.reset();
        }
    }
}
