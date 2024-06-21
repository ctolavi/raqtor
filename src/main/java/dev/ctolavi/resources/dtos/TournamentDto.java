package dev.ctolavi.resources.dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.time.LocalDate;

@RegisterForReflection
@Data
public class TournamentDto{
    private Long id;
    private String name;
    private LocalDate end_registration_date;
    private LocalDate start_date;
    private LocalDate end_date;
    private LocalDate createDate;
    private LocalDate updateDate;
}
