package dev.ctolavi.controllers;

import dev.ctolavi.entities.Player;
import dev.ctolavi.repositories.PlayerRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/players")
public class PlayerResource {

    @Inject
    PlayerRepository playerRepository;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPlayer(Player player) {
        playerRepository.persist(player);
        return Response.status(Response.Status.CREATED).entity(player).build();
    }

}
