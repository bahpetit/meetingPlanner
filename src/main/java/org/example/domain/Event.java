package org.example.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of={"room", "meeting"})
@ToString(of={"room", "meeting"})
@Data
public class Event {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Min(value = 1)
    private Long id;
    @NonNull
    @OneToOne
    private Room room;
    @NonNull
    @OneToOne
    private Meeting meeting;

}
