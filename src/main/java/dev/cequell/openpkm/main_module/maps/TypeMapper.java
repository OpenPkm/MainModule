package dev.cequell.openpkm.main_module.maps;

import dev.cequell.openpkm.main_module.dto.TypeResponseDto;
import dev.cequell.openpkm.main_module.entities.TypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public abstract class TypeMapper {
    public abstract TypeResponseDto map(TypeEntity entity);

    public dev.cequell.openpkm.main_module.proto.pokemon.TypeResponseDTO mapToProtoResponse(TypeEntity entity) {
        var typeBuilder = dev.cequell.openpkm.main_module.proto.pokemon.TypeResponseDTO.newBuilder();

        typeBuilder
                .setTypeUuid(entity.id.toString())
                .setName(entity.name)
                .setSlug(entity.slug);

        return typeBuilder.build();
    }
}
