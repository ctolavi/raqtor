package dev.ctolavi.repositories;

import dev.ctolavi.entities.PlayerClub;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerClubRepository implements PanacheRepository<PlayerClub> {
}
