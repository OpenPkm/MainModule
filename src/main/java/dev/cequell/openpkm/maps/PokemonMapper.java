package dev.cequell.openpkm.maps;

import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.entities.PokemonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "cdi")
public interface PokemonMapper {
    @Mapping(target = "value", source = "entity.id")
    @Mapping(target = "label", source = "entity.name")
    ValueText<UUID> toValueText(PokemonEntity entity);

    List<ValueText<UUID>> toValueText(List<PokemonEntity> entity);
}
