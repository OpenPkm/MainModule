package dev.cequell.openpkm.main_module.maps;

import dev.cequell.openpkm.main_module.dto.GenResponseDto;
import dev.cequell.openpkm.main_module.entities.GenEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface GenMapper {
    GenResponseDto toResponseDto(GenEntity entity);
    List<GenResponseDto> toResponseDto(List<GenEntity> entity);
}
