package dev.cequell.openpkm.interfaces.impl;

import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.entities.PokemonEntity;
import dev.cequell.openpkm.interfaces.IPokemonMapValueText;

import java.util.UUID;

public class RegionalNoWithNameAndVariationValueText implements IPokemonMapValueText {
    @Override
    public ValueText<UUID> execute(PokemonEntity entity) {
        return(entity.getVariation() == null)?
            new ValueText<>(entity.getId(), "%d - %s".formatted(entity.getRegionalDexNo(), entity.getName())) :
            new ValueText<>(entity.getId(), "%d - %s (%s form)".formatted(entity.getRegionalDexNo(), entity.getName(), entity.getVariation()));
    }
}
