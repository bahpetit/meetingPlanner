package org.example.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.example.domain.EquipmentType.Neant;
import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {
    private static Validator validator;
    Room room;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        room = new Room("E1001", 23);
    }

    @Test
    void testEquipmetOk(){
        Equipment equipement = new Equipment(1L, Neant, room);
        assertTrue(validator.validate(equipement).isEmpty());
    }

    @Test
    void testIdNegatif() {
        Equipment equipment = new Equipment(-1L, Neant, room);
        assertFalse(validator.validate(equipment).isEmpty());
    }

    @Test
    void testIdZero() {
        Equipment equipment = new Equipment(0L, Neant, room);
        assertFalse(validator.validate(equipment).isEmpty());
    }

    @Test
    void testEquipmentNull() {
        assertThrows(NullPointerException.class, () -> {
            Equipment equipement = new Equipment(1L, null, room);
        });
    }

}