package org.example.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;

import static org.example.domain.MeetingType.VC;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {
    private static Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testEventOK() {
        Room room = new  Room("E1001", 23);
        Meeting meeting = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC, 8);
        Event event = new Event(1L, room, meeting);
        assertTrue(validator.validate(event).isEmpty());
    }

    @Test
    void testIdNegatif() {
        Room room = new  Room("E1001", 23);
        Meeting meeting = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC, 8);
        Event event = new Event(-1L, room, meeting);
        assertFalse(validator.validate(event).isEmpty());
    }

    @Test
    void testIdZero() {
        Room room = new  Room("E1001", 23);
        Meeting meeting = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC, 8);
        Event event = new Event(0L, room, meeting);
        assertFalse(validator.validate(event).isEmpty());
    }

    @Test
    void testRoomNull() {
        assertThrows(NullPointerException.class, () -> {
            Meeting meeting = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC, 8);
            Event event = new Event(1L, null, meeting);
        });
    }

    @Test
    void testMeetingNull() {
        assertThrows(NullPointerException.class, () -> {
            Room room = new  Room("E1001", 23);
            Event event = new Event(1L, room, null);
            assertTrue(validator.validate(event).isEmpty());
        });
    }

}