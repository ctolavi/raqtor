package dev.ctolavi.controllers;

import dev.ctolavi.entities.Club;
import dev.ctolavi.entities.Player;
import dev.ctolavi.entities.PlayerClub;
import dev.ctolavi.repositories.ClubRepository;
import dev.ctolavi.repositories.PlayerClubRepository;
import dev.ctolavi.repositories.PlayerRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Year;
import java.util.List;

@ApplicationScoped
public class ClubController {

    private final ClubRepository clubRepository;

    private final PlayerRepository playerRepository;

    private final PlayerClubRepository playerClubRepository;

    public ClubController(ClubRepository clubRepository,
                          PlayerRepository playerRepository,
                          PlayerClubRepository playerClubRepository) {
        this.clubRepository = clubRepository;
        this.playerRepository = playerRepository;
        this.playerClubRepository = playerClubRepository;
    }

    public void save(Club club) {
        clubRepository.persist(club);
    }

    public List<Club> getAll() {
        return clubRepository.findAll().list();
    }

    public void addPlayer(Long clubId, Player player) {
        Player savedPlayer = playerRepository.findById(player.getId());
        Club club = clubRepository.findById(clubId);
        PlayerClub playerClub = new PlayerClub();
        playerClub.setClub(club);
        playerClub.setPlayer(savedPlayer);
        playerClub.setYear(Year.now().getValue());
        playerClubRepository.persist(playerClub);
    }

    public List<Player> getPlayersByClub(Long clubId) {
        Club club = clubRepository.findById(clubId);
        List<Player> players = playerClubRepository.find("club", club).list().stream().map(playerClub -> playerClub.getPlayer()).toList();
        return players;
    }
}
