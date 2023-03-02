package dev.cequell.openpkm.processing.impl;

import dev.cequell.openpkm.dto.PokemonRequestParamDto;
import dev.cequell.openpkm.entities.PokemonEntity;
import dev.cequell.openpkm.processing.RequestBaseProcess;

import java.util.stream.Stream;

public class ClassificationRequestProcess extends RequestBaseProcess {
    @Override
    protected Stream<PokemonEntity> handle(
            Stream<PokemonEntity> content,
            final PokemonRequestParamDto params
    ) {
        final var classification = params.classification;
        if(classification == null) return content;
        return content.filter(el -> el.classification.toLowerCase().contains(classification.toLowerCase()));
    }
}
