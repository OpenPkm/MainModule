package dev.cequell.openpkm.controllers;

import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.services.pokemon.PokemonAsValueTextService;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/pokemon")
public class PokemonController {
    private final PokemonAsValueTextService asValueTextService;

    @GET
    @Path("/AsValueText")
    public List<ValueText<UUID>> getList(@Context UriInfo uriInfo) {
        return asValueTextService.execute(uriInfo);
    }
}
