package dev.cequell.openpkm.main_module.interfaces.impl;

import dev.cequell.openpkm.main_module.dto.ValueText;
import dev.cequell.openpkm.main_module.entities.PokemonEntity;
import dev.cequell.openpkm.main_module.interfaces.IPokemonMapValueText;

import java.util.UUID;

public class NameAndVariationValueText implements IPokemonMapValueText {
    @Override
    public ValueText<UUID> execute(PokemonEntity entity) {
        final var label = (entity.variation == null) ?
            entity.name :
            "%s (%s form)".formatted(entity.name, entity.variation);

        return new ValueText<>(entity.id, label);
    }
}
