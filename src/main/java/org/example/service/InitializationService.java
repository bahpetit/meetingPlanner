package org.example.service;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.domain.*;
import org.example.repository.EventRepository;
import org.example.repository.MeetingRepository;
import org.example.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.example.domain.EquipmentType.*;
import static org.example.domain.EquipmentType.Neant;
import static org.example.domain.MeetingType.*;
import static org.example.domain.MeetingType.RS;

@Service
@RequiredArgsConstructor
public class InitializationService {

    @NonNull
    private final RoomRepository  roomRepository;

    @NonNull
    private final MeetingRepository meetingRepository;

    @NonNull
    private final EventRepository eventRepository;
    public void loadingRoom() {
        Room E1001 = new Room("E1001", 23);
        E1001.setEquipments(Arrays.asList(new Equipment(Neant, E1001)));
        Room E1002 = new Room("E1002", 10);
        E1002.setEquipments(Arrays.asList(new Equipment(Ecran, E1002)));
        Room E1003 = new Room("E1003", 8);
        E1003.setEquipments(Arrays.asList(new Equipment(Pieuvre, E1003)));
        Room E1004 = new Room("E1004", 4);
        E1004.setEquipments(Arrays.asList(new Equipment(Tableau, E1004)));
        Room E2001 = new Room("E2001", 4);
        E2001.setEquipments(Arrays.asList(new Equipment(Neant, E2001)));
        Room E2002 = new Room("E2002", 15);
        E2002.setEquipments(Arrays.asList(new Equipment(Ecran, E2002),
                new Equipment(Webcam, E2002)));
        Room E2003 = new Room("E2003", 7);
        E2003.setEquipments(Arrays.asList(new Equipment(Neant, E2003)));
        Room E2004 = new Room("E2004", 9);
        E2004.setEquipments(Arrays.asList(new Equipment(Tableau, E2004)));
        Room E3001 = new Room("E3001", 13);
        E3001.setEquipments(Arrays.asList(new Equipment(Ecran, E3001),
                new Equipment(Webcam, E3001),new Equipment(Pieuvre, E3001)));
        Room E3002 = new Room("E3002", 8);
        E3002.setEquipments(Arrays.asList(new Equipment(Neant, E3002)));
        Room E3003 = new Room("E3003", 9);
        E3003.setEquipments(Arrays.asList(new Equipment(Ecran, E3003),
                new Equipment(Pieuvre, E3003)));
        Room E3004 = new Room("E3004", 4);
        E3004.setEquipments(Arrays.asList(new Equipment(Neant, E3004)));
        List<Room> rooms = new ArrayList<>();
        rooms.add(E1001);
        rooms.add(E1002);
        rooms.add(E1003);
        rooms.add(E1004);
        rooms.add(E2001);
        rooms.add(E2002);
        rooms.add(E2003);
        rooms.add(E2004);
        rooms.add(E3001);
        rooms.add(E3002);
        rooms.add(E3003);
        rooms.add(E3004);
        this.roomRepository.saveAll(rooms);
    }

    public void loadingMeeting() {
        Meeting reunion01 = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC, 8);
        Meeting reunion02 = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), VC, 6);
        Meeting reunion03 = new Meeting(LocalDate.now().atTime(11, 0), LocalDate.now().atTime(12, 0), MeetingType.RC, 4);
        Meeting reunion04 = new Meeting(LocalDate.now().atTime(11, 0), LocalDate.now().atTime(12, 0), RS, 2);
        Meeting reunion05 = new Meeting(LocalDate.now().atTime(11, 0), LocalDate.now().atTime(12, 0), SPEC, 9);
        Meeting reunion06 = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), MeetingType.RC, 7);
        Meeting reunion07 = new Meeting(LocalDate.now().atTime(8, 0), LocalDate.now().atTime(9, 0), VC, 9);
        Meeting reunion08 = new Meeting(LocalDate.now().atTime(8, 0), LocalDate.now().atTime(9, 0), SPEC, 10);
        Meeting reunion09 = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), SPEC, 5);
        Meeting reunion10 = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), RS, 4);
        Meeting reunion11 = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), MeetingType.RC, 8);
        Meeting reunion12 = new Meeting(LocalDate.now().atTime(11, 0), LocalDate.now().atTime(12, 0), VC, 12);
        Meeting reunion13 = new Meeting(LocalDate.now().atTime(11, 0), LocalDate.now().atTime(12, 0), SPEC, 5);
        Meeting reunion14 = new Meeting(LocalDate.now().atTime(8, 0), LocalDate.now().atTime(9, 0), VC, 3);
        Meeting reunion15 = new Meeting(LocalDate.now().atTime(8, 0), LocalDate.now().atTime(9, 0), SPEC, 2);
        Meeting reunion16 = new Meeting(LocalDate.now().atTime(8, 0), LocalDate.now().atTime(9, 0), VC, 12);
        Meeting reunion17 = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), MeetingType.RC, 8);
        Meeting reunion18 = new Meeting(LocalDate.now().atTime(11, 0), LocalDate.now().atTime(12, 0), RS, 2);
        Meeting reunion19 = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), RS, 4);
        Meeting reunion20 = new Meeting(LocalDate.now().atTime(9, 0), LocalDate.now().atTime(10, 0), MeetingType.RC, 7);

        List<Meeting> meetings = new ArrayList<>();
        meetings.add(reunion01);
        meetings.add(reunion02);
        meetings.add(reunion03);
        meetings.add(reunion04);
        meetings.add(reunion05);
        meetings.add(reunion06);
        meetings.add(reunion07);
        meetings.add(reunion08);
        meetings.add(reunion09);
        meetings.add(reunion10);
        meetings.add(reunion11);
        meetings.add(reunion12);
        meetings.add(reunion13);
        meetings.add(reunion14);
        meetings.add(reunion15);
        meetings.add(reunion16);
        meetings.add(reunion17);
        meetings.add(reunion18);
        meetings.add(reunion19);
        meetings.add(reunion20);
        meetingRepository.saveAll(meetings);
    }


    public void initEvent() {
        List<Room> rooms = roomRepository.findAll();
        List<Meeting> meetings = meetingRepository.findAll();
        MeetingsSchedule meetingsSchedule = new MeetingsSchedule();
        rooms = rooms.stream().sorted(Comparator.comparing(Room::getName)).collect(Collectors.toList());
        meetings = meetings.stream().sorted(Comparator.comparing(Meeting::getStart)).collect(Collectors.toList());
        meetingsSchedule.initSlotMetingRoom(rooms);
        meetingsSchedule.preparemeetingsSchedule(rooms, meetings, 0.7);
        Set<Event> events = meetingsSchedule.getEvents();
        eventRepository.saveAll(events);
    }


}
