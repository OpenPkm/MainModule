package dev.cequell.openpkm.main_module.processing.impl;

import com.google.common.base.Strings;
import dev.cequell.openpkm.main_module.dto.PokemonRequestParamDto;
import dev.cequell.openpkm.main_module.entities.PokemonEntity;
import dev.cequell.openpkm.main_module.processing.RequestBaseProcess;

import java.util.stream.Stream;

public class VariationRequestProcess extends RequestBaseProcess {
    @Override
    protected Stream<PokemonEntity> handle(
            Stream<PokemonEntity> content,
            final PokemonRequestParamDto params
    ) {
        final var variation = params.variation;
        if(Strings.isNullOrEmpty(variation)) return content;
        return content.filter(el -> el.variation != null && el.variation.toLowerCase().contains(variation.toLowerCase()));
    }
}
