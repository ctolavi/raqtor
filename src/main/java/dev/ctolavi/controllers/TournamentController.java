package dev.ctolavi.controllers;

import dev.ctolavi.entities.Category;
import dev.ctolavi.entities.Tournament;
import dev.ctolavi.repositories.TournamentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class TournamentController {

    private final TournamentRepository tournamentRepository;

    public TournamentController(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public void save(Tournament tournament) {
        tournamentRepository.persist(tournament);
    }

    public List<Tournament> getAll() {
        return tournamentRepository.findAll().list();
    }

    public void addCategory(Long tournamentId, Category category) {
        Tournament tournament = tournamentRepository.findById(tournamentId);
        tournament.getCategories().add(category);
        tournamentRepository.persist(tournament);
    }

    public Set<Category> getCategories(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId);
        Hibernate.initialize(tournament.getCategories());
        return tournament.getCategories();
    }
}
