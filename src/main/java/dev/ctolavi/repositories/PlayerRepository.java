package dev.ctolavi.repositories;

import dev.ctolavi.entities.Player;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerRepository implements PanacheRepository<Player> {
}
