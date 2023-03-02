package dev.cequell.openpkm.maps;

import dev.cequell.openpkm.dto.GenResponseDto;
import dev.cequell.openpkm.entities.GenEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface GenMapper {
    GenResponseDto toResponseDto(GenEntity entity);
    List<GenResponseDto> toResponseDto(List<GenEntity> entity);
}
