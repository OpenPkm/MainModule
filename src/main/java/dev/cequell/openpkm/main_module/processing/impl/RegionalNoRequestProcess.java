package dev.cequell.openpkm.main_module.processing.impl;

import dev.cequell.openpkm.main_module.dto.PokemonRequestParamDto;
import dev.cequell.openpkm.main_module.entities.PokemonEntity;
import dev.cequell.openpkm.main_module.processing.RequestBaseProcess;

import java.util.stream.Stream;

public class RegionalNoRequestProcess extends RequestBaseProcess {
    @Override
    protected Stream<PokemonEntity> handle(
            Stream<PokemonEntity> content,
            final PokemonRequestParamDto params
    ) {
        final var regionalNo = params.regionalDexNo;
        if(regionalNo == null) return content;
        return content.filter(el -> el.regionalDexNo == regionalNo);
    }
}
