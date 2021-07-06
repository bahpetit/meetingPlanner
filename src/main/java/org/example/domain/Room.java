package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Room {
    private String name;
    private Integer capacity;
}
