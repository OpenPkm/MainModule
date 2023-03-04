package dev.cequell.openpkm.main_module.interfaces.impl;

import dev.cequell.openpkm.main_module.dto.ValueText;
import dev.cequell.openpkm.main_module.entities.PokemonEntity;
import dev.cequell.openpkm.main_module.interfaces.IPokemonMapValueText;

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
