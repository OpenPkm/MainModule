package dev.cequell.openpkm.processing.impl;

import dev.cequell.openpkm.dto.PokemonRequestParamDto;
import dev.cequell.openpkm.entities.PokemonEntity;
import dev.cequell.openpkm.processing.RequestBaseProcess;

import java.util.stream.Stream;

public class NameRequestProcess extends RequestBaseProcess {
    @Override
    protected Stream<PokemonEntity> handle(
            Stream<PokemonEntity> content,
            final PokemonRequestParamDto params
    ) {
        final var name = params.name;
        if(name == null) return content;
        return content.filter(el -> el.name.toLowerCase().contains(name.toLowerCase()));
    }
}
