package dev.ctolavi.resources;

import dev.ctolavi.controllers.ClubController;
import dev.ctolavi.entities.Club;
import dev.ctolavi.entities.Player;
import dev.ctolavi.resources.dtos.ClubDto;
import dev.ctolavi.resources.dtos.PlayerDto;
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

@Path("/clubs")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class ClubResource {

    private final ClubController clubController;

    private final Mapper mapper;

    public ClubResource(ClubController clubController, Mapper mapper) {
        this.clubController = clubController;
        this.mapper = mapper;
    }

    @POST
    public Response createClub(ClubDto clubDto) {
        Club club = mapper.map(clubDto, Club.class);
        clubController.save(club);
        return Response.status(Response.Status.CREATED).entity(mapper.map(club, ClubDto.class)).build();
    }

    @GET
    public Response listClubs() {
        List<Club> clubs = clubController.getAll();
        return Response.ok(mapper.map(clubs, new TypeToken<Set<ClubDto>>() {
        }.getType())).build();
    }

    @POST
    @Path("/{id}/players")
    public Response addPlayer(@PathParam("id") Long id, PlayerDto playerDto) {
        Player player = mapper.map(playerDto, Player.class);
        clubController.addPlayer(id, player);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}/players")
    public Response listPlayersByClubs(@PathParam("id") Long id) {
        List<Player> players = clubController.getPlayersByClub(id);
        return Response.ok(mapper.map(players, new TypeToken<Set<PlayerDto>>() {
        }.getType())).build();
    }

}
