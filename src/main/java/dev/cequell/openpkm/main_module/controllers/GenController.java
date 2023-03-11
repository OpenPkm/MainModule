package dev.cequell.openpkm.main_module.controllers;

import dev.cequell.openpkm.main_module.dto.GenResponseDto;
import dev.cequell.openpkm.main_module.services.gen.GenService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@SuppressWarnings("unused")
@RequiredArgsConstructor
@GraphQLApi
public class GenController {
    private final GenService genService;

    @Query("getAllGenerations")
    @Description("Get all generations list")
    public List<GenResponseDto> All() {
        return genService.getAll();
    }
}
