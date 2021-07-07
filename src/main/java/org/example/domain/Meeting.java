package org.example.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(of={"id", "start", "end", "nbPerson"})
@EqualsAndHashCode(of={"start", "end"})
@Data
public class Meeting {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

    @Override
    public int hashCode() {
        return 1;
    }
}
