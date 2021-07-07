package org.example.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(of = {"name","capacity"})
@EqualsAndHashCode(of={"name"})
@Data
public class Room {

    @Id
    @NonNull
    @NotBlank
    private String name;

    @NonNull
    @NotNull
    @Min(value = 1)
    private Integer capacity;

    @OneToMany( mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Equipment> equipments = new ArrayList<>();


}
