package org.example.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.example.domain.Equipmenttype.Neant;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EquipmentTest {
    private static Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testEquipmetOk(){
        Equipment equipement = new Equipment(1L, Neant);
        assertTrue(validator.validate(equipement).isEmpty());
    }

    @Test
    void testIdNegatif() {
        Equipment equipment = new Equipment(-1L, Neant);
        assertFalse(validator.validate(equipment).isEmpty());
    }

    @Test
    void testIdZero() {
        Equipment equipment = new Equipment(0L, Neant);
        assertFalse(validator.validate(equipment).isEmpty());
    }

    @Test
    void testEquipmentNull() {
        Equipment equipement = new Equipment(1L, null);
        assertFalse(validator.validate(equipement).isEmpty());
    }

}