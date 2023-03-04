package dev.cequell.openpkm.main_module.maps;

import dev.cequell.openpkm.main_module.dto.PokemonResponseDto;
import dev.cequell.openpkm.main_module.dto.ValueText;
import dev.cequell.openpkm.main_module.entities.PokemonEntity;
import dev.cequell.openpkm.main_module.enums.PokemonMapTypeEnum;
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
    public abstract PokemonResponseDto mapResponse(PokemonEntity entity);

    public List<ValueText<UUID>> toValueText(
            List<PokemonEntity> entityList,
            PokemonMapTypeEnum typeEnum) {
        return entityList.stream().map(el -> toValueText(el, typeEnum)).collect(Collectors.toList());
    }
    public abstract List<PokemonResponseDto> mapResponse(List<PokemonEntity> entityList);
}
