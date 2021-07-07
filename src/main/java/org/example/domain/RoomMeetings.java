package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class RoomMeetings {
    private  Room room;
    private List<Meeting> meetings = new ArrayList<>();
}
