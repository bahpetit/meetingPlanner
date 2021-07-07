package org.example.domain;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class MeetingsSchedule {

    public Boolean checkCapacityRoom(Meeting meeting, Room room, Double percentage) {
        return ((Double.valueOf(room.getCapacity()) * percentage) >= Double.valueOf(meeting.getNbPerson()));
    }

    public Room getOptimaleRoom(Meeting meeting, List<Room> rooms) {
        Room result = null;
        Integer findsnallest = Integer.MAX_VALUE;
        for(Room room: rooms){
            Integer diff = room.getCapacity() - meeting.getNbPerson();
            if(  diff < findsnallest){
                findsnallest = diff ;
                result = room;
            }
        }
        return result;
    }

}
