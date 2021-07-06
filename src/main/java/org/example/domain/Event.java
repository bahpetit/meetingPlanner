package org.example.domain;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Min;

@AllArgsConstructor
@RequiredArgsConstructor
public class Event {

    @Min(value = 1)
    private Long id;
    @NonNull
    private Room room;
    @NonNull
    private Meeting meeting;

}
