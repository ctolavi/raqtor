package dev.ctolavi.repositories;

import dev.ctolavi.entities.Tournament;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TournamentRepository implements PanacheRepository<Tournament> {
}
