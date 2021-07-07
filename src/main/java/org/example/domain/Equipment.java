package org.example.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(of={"equipmentType", "room"})
@EqualsAndHashCode(of={"equipmentType"})
@Data
public class Equipment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Min(value = 1L)
    private Long Id;

    @NonNull
    @NotNull
    @Enumerated(EnumType.STRING)
    private EquipmentType equipmentType;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

}
