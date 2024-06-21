package dev.ctolavi.resources;

import dev.ctolavi.controllers.TournamentController;
import dev.ctolavi.entities.Category;
import dev.ctolavi.entities.Tournament;
import dev.ctolavi.resources.dtos.CategoryDto;
import dev.ctolavi.resources.dtos.TournamentDto;
import dev.ctolavi.resources.mapper.Mapper;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.Set;

@Path("/tournaments")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class TournamentResource {

    private final TournamentController tournamentController;

    private final Mapper mapper;

    public TournamentResource(TournamentController tournamentController, Mapper mapper) {
        this.tournamentController = tournamentController;
        this.mapper = mapper;
    }

    @POST
    public Response createTournament(TournamentDto tournamentDto) {
        Tournament tournament = mapper.map(tournamentDto, Tournament.class);
        tournamentController.save(tournament);
        TournamentDto savedTournament = mapper.map(tournament, TournamentDto.class);
        return Response.status(Response.Status.CREATED).entity(savedTournament).build();
    }

    @GET
    public Response listTournaments() {
        List<Tournament> tournaments = tournamentController.getAll();
        return Response
                .ok(mapper.map(tournaments, new TypeToken<List<TournamentDto>>() {
                }.getType()))
                .build();
    }

    @POST
    @Path("/{id}/categories")
    public Response createTournament(@PathParam("id") Long id, CategoryDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        tournamentController.addCategory(id, category);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}/categories")
    public Response listCategoriesByTournament(@PathParam("id") Long id) {
        Set<Category> categories = tournamentController.getCategories(id);
        return Response
                .ok(mapper.map(categories, new TypeToken<Set<CategoryDto>>() {
                }.getType()))
                .build();
    }

}
