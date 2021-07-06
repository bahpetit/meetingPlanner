package org.example.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;

import static org.example.domain.MeetingType.*;
import static org.junit.jupiter.api.Assertions.*;

class MeetingTest {

    private static Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testMeetingOK() {
        Meeting meeting = new Meeting(1L, LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC, 8);
        assertTrue(validator.validate(meeting).isEmpty());
    }

    @Test
    void testIdNegatif() {
        Meeting meeting = new Meeting(-1L, LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC,8);
        assertFalse(validator.validate(meeting).isEmpty());
    }

    @Test
    void testIdZero() {
        Meeting meeting = new Meeting(0L, LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC,8);
        assertFalse(validator.validate(meeting).isEmpty());
    }

    @Test
    void testStartNull() {
        assertThrows(NullPointerException.class, () -> {
            Meeting meeting = new Meeting(1L,null, LocalDate.now().atTime(10, 0), VC,8);
        });
    }

    @Test
    void testEndNull() {
        assertThrows(NullPointerException.class, () -> {
            Meeting meeting = new Meeting(1L,LocalDate.now().atTime(9, 0), null, VC, 8);
        });
    }

    @Test
    void testMeetingTypeNull() {
        assertThrows(NullPointerException.class, () -> {
            Meeting meeting = new Meeting(1L,LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), null, 8);
        });
    }

    @Test
    void testNbPersonNegative() {
        Meeting meeting = new Meeting(1L,LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC, -1);
        assertFalse(validator.validate(meeting).isEmpty());
    }

    @Test
    void testNbPersonNull() {
        assertThrows(NullPointerException.class, () -> {
            Meeting meeting = new Meeting(1L,LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC, null);
        });
    }

    @Test
    void testNotEqualsByInterval() {
        Meeting meeting_9h_10h = new Meeting(1L, LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC, 8);
        Meeting meeting_12h_13h = new Meeting(1L, LocalDate.now().atTime(12, 0), LocalDate.now().atTime(13, 0), VC, 8);
        assertFalse(meeting_9h_10h.equals(meeting_12h_13h));
    }

    @Test
    void testEqualsByInterval() {
        Meeting meeting_9h_10h = new Meeting(1L, LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC, 8);
        Meeting meeting_10h_11h = new Meeting(1L, LocalDate.now().atTime(10, 0), LocalDate.now().atTime(11, 0), VC, 8);
        assertTrue(meeting_9h_10h.equals(meeting_10h_11h));
    }


}