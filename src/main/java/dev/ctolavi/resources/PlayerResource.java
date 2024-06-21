package dev.ctolavi.resources;

import dev.ctolavi.controllers.PlayerController;
import dev.ctolavi.entities.Player;
import dev.ctolavi.resources.dtos.PlayerDto;
import dev.ctolavi.resources.mapper.Mapper;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.Set;

@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class PlayerResource {

    private final PlayerController playerController;

    private final Mapper mapper;

    public PlayerResource(PlayerController playerController, Mapper mapper) {
        this.playerController = playerController;
        this.mapper = mapper;
    }

    @POST
    public Response createPlayer(PlayerDto playerDto) {
        Player player = mapper.map(playerDto, Player.class);
        playerController.save(player);
        return Response.status(Response.Status.CREATED).entity(mapper.map(player, PlayerDto.class)).build();
    }

    @GET
    public Response listPlayers() {
        List<Player> players = playerController.getAll();
        return Response.ok(mapper.map(players, new TypeToken<Set<PlayerDto>>() {
        }.getType())).build();
    }

}
