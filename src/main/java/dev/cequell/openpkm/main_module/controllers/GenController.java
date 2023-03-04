package dev.cequell.openpkm.main_module.controllers;

import dev.cequell.openpkm.main_module.dto.GenResponseDto;
import dev.cequell.openpkm.main_module.services.GenService;
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
