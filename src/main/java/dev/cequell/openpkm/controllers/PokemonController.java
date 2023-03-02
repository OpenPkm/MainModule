package dev.cequell.openpkm.controllers;

import dev.cequell.openpkm.dto.PagedDto;
import dev.cequell.openpkm.dto.PokemonRequestParamDto;
import dev.cequell.openpkm.dto.PokemonResponseDto;
import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.enums.PokemonMapTypeEnum;
import dev.cequell.openpkm.services.pokemon.AsValueTextService;
import dev.cequell.openpkm.services.pokemon.ByIdService;
import dev.cequell.openpkm.services.pokemon.PagedService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@GraphQLApi
public class PokemonController {
    private final AsValueTextService asValueTextService;
    private final ByIdService byIdService;
    private final PagedService pagedService;

    @Query("getPokemonAsValueText")
    @Description("Get pokemon list inf ValueText format")
    public List<ValueText<UUID>> asValueText(
            @Name("mode") PokemonMapTypeEnum mode,
            @Name("filterBy")PokemonRequestParamDto params
    ) {
        return asValueTextService.execute(mode, params);
    }

    @Query("getPokemonById")
    @Description("Get a pokemon by Id")
    public PokemonResponseDto byId(
            @Name("id") final UUID id
    ) {
        return byIdService.execute(id);
    }

    @Query("getPokemonPaged")
    @Description("Get paged/filtered pokémon list")
    public PagedDto<PokemonResponseDto> paged(
            @Name("page") int page,
            @Name("size") int size,
            @Name("filterBy")PokemonRequestParamDto params
    ) {
        return pagedService.execute(page, size, params);
    }
}
