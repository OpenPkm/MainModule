package dev.cequell.openpkm.main_module.controllers;

import dev.cequell.openpkm.main_module.dto.TypeResponseDto;
import dev.cequell.openpkm.main_module.services.type.TypeAllService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@SuppressWarnings("unused")
@RequiredArgsConstructor
@GraphQLApi
public class TypeController {
    private final TypeAllService typeAllService;

    @Query("getTypeAsValueText")
    @Description("Get type list in ValueText format")
    public List<TypeResponseDto> all() {
        return typeAllService.execute();
    }
}
