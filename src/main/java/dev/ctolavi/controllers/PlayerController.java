package dev.ctolavi.controllers;

import dev.ctolavi.entities.Player;
import dev.ctolavi.repositories.PlayerRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void save(Player player) {
        playerRepository.persist(player);
    }

    public List<Player> getAll() {
        return playerRepository.findAll().list();
    }

}
