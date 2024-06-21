package dev.ctolavi.repositories;

import dev.ctolavi.entities.Club;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClubRepository implements PanacheRepository<Club> {
}
