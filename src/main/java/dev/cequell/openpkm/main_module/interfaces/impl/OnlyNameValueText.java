package dev.cequell.openpkm.main_module.interfaces.impl;

import dev.cequell.openpkm.main_module.dto.ValueText;
import dev.cequell.openpkm.main_module.entities.PokemonEntity;
import dev.cequell.openpkm.main_module.interfaces.IPokemonMapValueText;

import java.util.UUID;

public class OnlyNameValueText implements IPokemonMapValueText {
    @Override
    public ValueText<UUID> execute(PokemonEntity entity) {
        return new ValueText<>(entity.id, entity.name);
    }
}
