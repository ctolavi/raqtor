package dev.ctolavi.resources.dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.time.LocalDate;

@RegisterForReflection
@Data
public class ClubDto {
    private Long id;
    private String street;
    private String name;
    private String shortName;
    private String logo;
    private String city;
    private String country;
    private LocalDate createDate;
    private LocalDate updateDate;
}
