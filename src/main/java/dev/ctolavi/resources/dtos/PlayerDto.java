package dev.ctolavi.resources.dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.time.LocalDate;

@RegisterForReflection
@Data
public class PlayerDto {
    private Long id;
    private String name;
    private String surnames;
    private LocalDate createDate;
    private LocalDate updateDate;
}
