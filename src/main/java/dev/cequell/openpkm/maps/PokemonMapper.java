package dev.cequell.openpkm.maps;

import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.entities.PokemonEntity;
import dev.cequell.openpkm.enums.PokemonMapTypeEnum;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public abstract class PokemonMapper {

    public ValueText<UUID> toValueText(
            PokemonEntity entity,
            PokemonMapTypeEnum typeEnum
    ) {
        return typeEnum.execute(entity);
    }

    public List<ValueText<UUID>> toValueText(
            List<PokemonEntity> entityList,
            PokemonMapTypeEnum typeEnum) {
        return entityList.stream().map(el -> toValueText(el, typeEnum)).collect(Collectors.toList());
    }
}
