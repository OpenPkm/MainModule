package dev.cequell.openpkm.processing.impl;

import dev.cequell.openpkm.dto.PokemonRequestParamDto;
import dev.cequell.openpkm.entities.PokemonEntity;
import dev.cequell.openpkm.enums.PokemonFieldEnum;
import dev.cequell.openpkm.processing.RequestBaseProcess;

import java.util.stream.Stream;

public class SortProcessing extends RequestBaseProcess {
    @Override
    protected Stream<PokemonEntity> handle(
            Stream<PokemonEntity> content,
            final PokemonRequestParamDto params
    ) {
        final var sortBy = params.sortBy==null?
                PokemonFieldEnum.NATIONAL_DEX_NO :
                params.sortBy;
        final var desc = params.reverseOrder==null? 1 :
                         params.reverseOrder ? -1 : 1;

        return content.sorted((lhs, rhs) -> desc * switch (sortBy) {
            case REGIONAL_DEX_NO -> lhs.regionalDexNo-rhs.regionalDexNo;
            case GENERATION -> lhs.gen.no-rhs.gen.no;
            case WEIGHT -> (int) Math.signum(lhs.weight-rhs.weight);
            case HEIGHT -> (int) Math.signum(lhs.height-rhs.height);
            case NAME -> lhs.name.compareTo(rhs.name);
            default -> lhs.nationalDexNo-rhs.nationalDexNo;
        });
    }
}
