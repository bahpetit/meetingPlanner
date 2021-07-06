package org.example.domain;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@ToString(of = {"nom","capacite"})
@EqualsAndHashCode(of={"nom"})
@Data
public class Room {

    @NonNull
    @NotBlank
    private String name;

    @NonNull
    @NotNull
    @Min(value = 1)
    private Integer capacity;

    List<Equipment> equipements = new ArrayList<>();
}
