package org.example.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetingsScheduleTest {

    @Test
    void shouldReturnRoomCapacityIsOK(){
        Meeting meeting = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), MeetingType.VC, 8);
        Room room = new Room("E1001", 23);
        assertTrue(new MeetingsSchedule().checkCapacityRoom(meeting, room, 0.7));
    }

    @Test
    void shouldReturnRoomCapacityIsKO(){
        Meeting meeting = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), MeetingType.VC, 8);
        Room room = new Room("E1001", 5);
        assertFalse(new MeetingsSchedule().checkCapacityRoom(meeting, room, 0.7));
    }

    @Test
    void shouldReturnOptimalRoom() {
        // Algo meilleur voisin
        Meeting reunion01 = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), MeetingType.VC, 8);
        List<Room> rooms = Arrays.asList( new Room("E1001", 23), new Room("E1002", 10), new Room("E1003", 8));
        assertEquals(new Room("E1003", 8), new MeetingsSchedule().getOptimaleRoom(reunion01, rooms));
    }

    void shouldReturnEquipedRoom(){
        //Algo de glouton
        //Meilleur choix pour les equiments pour les salle manqunt
        Meeting reunion01 = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), MeetingType.VC, 8);

    }
}