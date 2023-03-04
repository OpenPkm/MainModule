package dev.cequell.openpkm.main_module.processing.impl;

import dev.cequell.openpkm.main_module.dto.PokemonRequestParamDto;
import dev.cequell.openpkm.main_module.entities.PokemonEntity;
import dev.cequell.openpkm.main_module.enums.TypeSlugEnum;
import dev.cequell.openpkm.main_module.processing.RequestBaseProcess;

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
