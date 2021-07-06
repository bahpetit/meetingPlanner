package org.example.domain;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString(of={"id", "description", "start", "end", "nbPerson"})
@EqualsAndHashCode(of={"start", "end"})
@Data
public class Meeting {

    @Min(value = 1)
    private Long id;

    @NonNull
    @NotNull
    private LocalDateTime start;

    @NonNull
    private LocalDateTime end;

    @NonNull
    private MeetingType meetingType;

    @NonNull
    @NotNull
    @Min(value = 1)
    private Integer nbPerson;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting that = (Meeting) o;
        return that.getStart().isBefore(this.end.plusHours(1)) && that.getEnd().isAfter(this.start);
    }

}
