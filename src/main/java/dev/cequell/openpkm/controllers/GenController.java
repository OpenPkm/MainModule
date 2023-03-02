package dev.cequell.openpkm.controllers;

import dev.cequell.openpkm.dto.GenResponseDto;
import dev.cequell.openpkm.services.GenService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@RequiredArgsConstructor
@GraphQLApi
public class GenController {
    private final GenService genService;

    @Query("getAllGenerations")
    public List<GenResponseDto> All() {
        return genService.getAll();
    }
}
