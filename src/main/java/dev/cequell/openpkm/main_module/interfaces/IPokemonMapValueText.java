package dev.cequell.openpkm.main_module.interfaces;

import dev.cequell.openpkm.main_module.dto.ValueText;
import dev.cequell.openpkm.main_module.entities.PokemonEntity;

import java.util.UUID;

public interface IPokemonMapValueText {
    ValueText<UUID> execute(PokemonEntity entity);
}
