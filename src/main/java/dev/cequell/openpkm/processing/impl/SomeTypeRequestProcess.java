package dev.cequell.openpkm.processing.impl;

import dev.cequell.openpkm.dto.PokemonRequestParamDto;
import dev.cequell.openpkm.entities.PokemonEntity;
import dev.cequell.openpkm.enums.TypeSlugEnum;
import dev.cequell.openpkm.processing.RequestBaseProcess;

import java.util.stream.Stream;

public class SomeTypeRequestProcess extends RequestBaseProcess {
    @Override
    protected Stream<PokemonEntity> handle(
            Stream<PokemonEntity> content,
            final PokemonRequestParamDto params
    ) {
        final var types = params.types;
        if(types == null) return content;

        final var typeIdList = types.stream().map(TypeSlugEnum::getValue).toList();
        return content.filter(
                el -> typeIdList.contains(el.primaryType.id) ||
                (el.secondaryType != null && typeIdList.contains((el.secondaryType.id)))
        );
    }
}
