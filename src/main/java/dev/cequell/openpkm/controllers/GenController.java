package dev.cequell.openpkm.controllers;

import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.services.GenService;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/gen")
public class GenController {
    private final GenService genService;

    @GET
    @Path("/AsValueText")
    public List<ValueText<UUID>> getAllAsValueText() {
        return genService.getAllAsValueText();
    }
}
