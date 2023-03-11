package dev.cequell.openpkm.main_module.maps;

import dev.cequell.openpkm.main_module.dto.TypeResponseDto;
import dev.cequell.openpkm.main_module.entities.TypeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface TypeMapper {
    TypeResponseDto map(TypeEntity entity);

    List<TypeResponseDto> map(List<TypeEntity> entityList);
}
