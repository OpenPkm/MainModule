package dev.cequell.openpkm.interfaces;

import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.entities.PokemonEntity;

import java.util.UUID;

public interface IPokemonMapValueText {
    ValueText<UUID> execute(PokemonEntity entity);
}
