package dev.ctolavi.resources.dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.time.LocalDate;

@RegisterForReflection
@Data
public class CategoryDto {
    private Long id;
    private String name;
    private String shortName;
    private LocalDate createDate;
    private LocalDate updateDate;
}
