package dev.cequell.openpkm.interfaces.impl;

import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.entities.PokemonEntity;
import dev.cequell.openpkm.interfaces.IPokemonMapValueText;

import java.util.UUID;

public class OnlyNameValueText implements IPokemonMapValueText {
    @Override
    public ValueText<UUID> execute(PokemonEntity entity) {
        return new ValueText<>(entity.getId(), entity.getName());
    }
}
