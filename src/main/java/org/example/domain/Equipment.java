package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@Data
public class Equipment {

    @Min(value = 1L)
    private Long Id;

    @NotNull
    private Equipmenttype equipmenttype;

}
