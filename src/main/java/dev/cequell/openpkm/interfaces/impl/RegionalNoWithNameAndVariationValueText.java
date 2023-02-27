package dev.cequell.openpkm.interfaces.impl;

import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.entities.PokemonEntity;
import dev.cequell.openpkm.interfaces.IPokemonMapValueText;

import java.util.UUID;

public class RegionalNoWithNameAndVariationValueText implements IPokemonMapValueText {
    @Override
    public ValueText<UUID> execute(PokemonEntity entity) {
        final var label = (entity.variation == null)?
            "%d - %s".formatted(entity.regionalDexNo, entity.name) :
            "%d - %s (%s form)".formatted(entity.regionalDexNo, entity.name, entity.variation);

        return new ValueText<>(entity.id, label);
    }
}
