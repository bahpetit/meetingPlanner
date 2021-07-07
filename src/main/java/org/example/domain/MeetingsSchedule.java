package org.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.example.domain.EquipmentType.*;
import static org.example.domain.MeetingType.*;

@NoArgsConstructor
@Data
public class MeetingsSchedule {

    private Map<String, Map<String, Integer>> slots = new HashMap<>();
    private Set<Event> events = new HashSet<>();
    private Map<EquipmentType, Integer> equipmentAvailable = new EnumMap<>(EquipmentType.class);

    private List<Room> roomMeetingCapacity(Meeting meeting, List<Room> rooms, Double percentage) {
        List<Room> results = new ArrayList<>();
        for (Room room: rooms){
            if(checkCapacityRoom(meeting, room, percentage) && !this.events.contains(new Event(room, meeting))){
                results.add(room);
            }
        }
        return results;
    }

    public boolean checkCapacityRoom(Meeting meeting, Room room, Double percentage) {
        return ((Double.valueOf(room.getCapacity()) * percentage) >= Double.valueOf(meeting.getNbPerson()));
    }

    public Room getOptimaleRoom(Meeting meeting, List<Room> rooms) {
        Room result = null;
        Integer findsnallest = Integer.MAX_VALUE;
        for(Room room: rooms){
            Integer diff = room.getCapacity() - meeting.getNbPerson();
            if(  (diff >= 0) && (diff < findsnallest)){
                findsnallest = diff ;
                result = room;
            }
        }
        return result;
    }

    public void preparemeetingsSchedule(List<Room> rooms, List<Meeting> meetings, double percentage) {
        Queue<Meeting> meetingQueue = new ArrayDeque<>();
        for(Meeting meeting: meetings){
            meetingQueue.add(meeting);
        }
        while (!meetingQueue.isEmpty()){
            var meeting = meetingQueue.remove();
            List<Room> roomsCapacity = roomMeetingCapacity(meeting, rooms, percentage);
            var roomOptimal = getOptimaleRoom(meeting, roomsCapacity);
            if(roomOptimal != null){
                var event =  new Event(roomOptimal, meeting);
                meetingScheduler(event);
            }
        }
    }

    private void meetingScheduler(Event event) {
        String name = event.getRoom().getName();
        Integer start = event.getMeeting().getStart().getHour();
        Integer end = event.getMeeting().getEnd().getHour();
        String slot = start +"-"+ end;
        Map<String, Integer> slotRoom = this.slots.get(name);
        if(slotRoom.get(slot) == 0) {
            this.slots.put(name, lockSlots(start, end, slotRoom));
            this.events.add(event);
        }
    }

    private Map<String, Integer> lockSlots(Integer start, Integer end, Map<String, Integer> slotRoom) {
        String slot = start +"-"+ end;
        String slotNext = end +"-"+ (end+1);
        String slotPrec = (start-1) +"-"+ start;
        if(start == 8) {
            slotRoom.put(slot, 1);
            slotRoom.put(slotNext, 1);
        }else if (start == 19) {
            slotRoom.put(slot, 1);
            slotRoom.put(slotPrec, 1);
        }else {
            slotRoom.put(slot, 1);
            slotRoom.put(slotNext, 1);
            slotRoom.put(slotPrec, 1);
        }
        return slotRoom;
    }


    public void initSlotMetingRoom(List<Room> rooms) {
        Map<EquipmentType, Integer> equipmentType = new EnumMap<>(EquipmentType.class);
        equipmentType.put(Pieuvre, 4);
        equipmentType.put(Ecran, 5);
        equipmentType.put(Webcam, 4);
        equipmentType.put(Tableau, 2);
        for(Room room: rooms){
            Map<String, Integer> slot = new HashMap<>();
            for(var i = 8; i < 20; i++){
                slot.put(i+"-"+ (i+1), 0);
            }
            slots.put(room.getName(), slot);
        }
        setSlots(slots);
        setEquipmentAvailable(equipmentType);
    }

    private boolean checkEquipedRoom(Room room, Meeting meeting) {
        Map<MeetingType, List<EquipmentType>> meetingByEquipemts = new HashMap<>();
        meetingByEquipemts.put(VC, Arrays.asList(Ecran, Pieuvre, Webcam));
        meetingByEquipemts.put(SPEC, Arrays.asList(Tableau));
        meetingByEquipemts.put(RS, Arrays.asList(Neant));
        meetingByEquipemts.put(RC, Arrays.asList(Tableau, Ecran, Pieuvre));
        List<EquipmentType> equipementSalles = room.getEquipments().stream().map(equipement -> equipement.getEquipmentType()).sorted().collect(Collectors.toList());;
        List<EquipmentType> equipementsMeeting = meetingByEquipemts.get(meeting.getMeetingType()).stream().sorted().collect(Collectors.toList());
        return equipementSalles.equals(equipementsMeeting);
    }

}
