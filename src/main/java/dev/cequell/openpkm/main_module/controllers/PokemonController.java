package dev.cequell.openpkm.main_module.controllers;

import dev.cequell.openpkm.main_module.dto.PagedDto;
import dev.cequell.openpkm.main_module.dto.PokemonRequestParamDto;
import dev.cequell.openpkm.main_module.dto.PokemonResponseDto;
import dev.cequell.openpkm.main_module.dto.ValueText;
import dev.cequell.openpkm.main_module.enums.PokemonMapTypeEnum;
import dev.cequell.openpkm.main_module.services.pokemon.PokemonAsValueTextService;
import dev.cequell.openpkm.main_module.services.pokemon.PokemonByIdService;
import dev.cequell.openpkm.main_module.services.pokemon.PokemonPagedService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
@RequiredArgsConstructor
@GraphQLApi
public class PokemonController {
    private final PokemonAsValueTextService pokemonAsValueTextService;
    private final PokemonByIdService pokemonByIdService;
    private final PokemonPagedService pokemonPagedService;

    @Query("getPokemonAsValueText")
    @Description("Get pokemon list in ValueText format")
    public List<ValueText<UUID>> asValueText(
            @Name("mode") PokemonMapTypeEnum mode,
            @Name("filterBy")PokemonRequestParamDto params
    ) {
        return pokemonAsValueTextService.execute(mode, params);
    }

    @Query("getPokemonById")
    @Description("Get a pokemon by Id")
    public PokemonResponseDto byId(
            @Name("id") final UUID id
    ) {
        return pokemonByIdService.execute(id);
    }

    @Query("getPokemonPaged")
    @Description("Get paged/filtered pokémon list")
    public PagedDto<PokemonResponseDto> paged(
            @Name("page") int page,
            @Name("size") int size,
            @Name("filterBy")PokemonRequestParamDto params
    ) {
        return pokemonPagedService.execute(page, size, params);
    }
}
