package dev.cequell.openpkm.main_module.processing.impl;

import com.google.common.base.Strings;
import dev.cequell.openpkm.main_module.dto.PokemonRequestParamDto;
import dev.cequell.openpkm.main_module.entities.PokemonEntity;
import dev.cequell.openpkm.main_module.processing.RequestBaseProcess;

import java.util.stream.Stream;

public class NameRequestProcess extends RequestBaseProcess {
    @Override
    protected Stream<PokemonEntity> handle(
            Stream<PokemonEntity> content,
            final PokemonRequestParamDto params
    ) {
        final var name = params.name;
        if(Strings.isNullOrEmpty(name)) return content;
        return content.filter(el -> el.name.toLowerCase().contains(name.toLowerCase()));
    }
}
