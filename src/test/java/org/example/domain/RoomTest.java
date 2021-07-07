package org.example.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;

import static org.example.domain.MeetingType.VC;
import static org.junit.jupiter.api.Assertions.*;


class RoomTest {

    private static Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testNameCapacityOK() {
        Room room = new  Room("E1001", 23);
        assertTrue(validator.validate(room).isEmpty());
    }

    @Test
    void testNameEmpty(){
        Room room = new Room("", 23);
        assertFalse(validator.validate(room).isEmpty());
    }

    @Test
    void testNameNull(){
        assertThrows(NullPointerException.class, () -> {
            Room room = new Room(null, 23);
        });
    }

    @Test
    void testCapaciteNull(){
        assertThrows(NullPointerException.class, () -> {
            Room room = new Room("E1001", null);
        });
    }

    @Test
    void testCapaciteSmaller_1(){
        Room room = new Room("E1001", 0);
        assertFalse(validator.validate(room).isEmpty());
    }

    @Test
    void testCapaciteIs_1(){
        Room room = new Room("E1001", 1);
        assertTrue(validator.validate(room).isEmpty());
    }




}