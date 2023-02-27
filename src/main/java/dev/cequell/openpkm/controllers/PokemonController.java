package dev.cequell.openpkm.controllers;

import dev.cequell.openpkm.dto.PagedDto;
import dev.cequell.openpkm.dto.PokemonResponseDto;
import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.services.pokemon.AsValueTextService;
import dev.cequell.openpkm.services.pokemon.ByIdService;
import dev.cequell.openpkm.services.pokemon.PagedService;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.*;
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
    private final AsValueTextService asValueTextService;
    private final ByIdService byIdService;
    private final PagedService pagedService;

    @GET
    @Path("{id}")
    public PokemonResponseDto byId(final UUID id) {
        return byIdService.execute(id);
    }

    @GET
    @Path("/AsValueText")
    public List<ValueText<UUID>> asValueText(
            @QueryParam("mode") String mode,
            @Context UriInfo uriInfo
    ) {
        return asValueTextService.execute(mode, uriInfo);
    }

    @GET
    @Path("/Paged")
    public PagedDto<PokemonResponseDto> paged(
            @QueryParam("page") int page,
            @QueryParam("size") int size,
            @Context UriInfo uriInfo
    ) {
        return pagedService.execute(page, size, uriInfo);
    }
}
