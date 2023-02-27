package dev.cequell.openpkm.interfaces.impl;

import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.entities.PokemonEntity;
import dev.cequell.openpkm.interfaces.IPokemonMapValueText;

import java.util.UUID;

public class NationalNoWithNameAndVariationValueText implements IPokemonMapValueText {
    @Override
    public ValueText<UUID> execute(PokemonEntity entity) {
        final var label = (entity.variation == null)?
            "%d - %s".formatted(entity.nationalDexNo, entity.name) :
            "%d - %s (%s form)".formatted(entity.nationalDexNo, entity.name, entity.variation);

        return new ValueText<>(entity.id, label);
    }
}
