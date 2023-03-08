package dev.cequell.openpkm.main_module.maps;

import dev.cequell.openpkm.main_module.dto.PokemonResponseDto;
import dev.cequell.openpkm.main_module.dto.ValueText;
import dev.cequell.openpkm.main_module.entities.PokemonEntity;
import dev.cequell.openpkm.main_module.enums.PokemonMapTypeEnum;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "cdi",
        imports = { TypeMapper.class }
)
public abstract class PokemonMapper {

    public ValueText<UUID> toValueText(
            PokemonEntity entity,
            PokemonMapTypeEnum typeEnum
    ) {
        return typeEnum.execute(entity);
    }
    public abstract PokemonResponseDto mapResponse(PokemonEntity entity);

    public dev.cequell.openpkm.main_module.proto.pokemon.PokemonResponseDto mapAsProtoResponse(PokemonEntity entity) {
        final var resultBuilder = dev.cequell.openpkm.main_module.proto.pokemon.PokemonResponseDto.newBuilder();

        final var variation = (entity.variation==null)? "" : entity.variation;

        resultBuilder
                .setPokemonUuid(entity.id.toString())
                .setNationalDexNo(entity.nationalDexNo)
                .setRegionalDexNo(entity.regionalDexNo)
                .setName(entity.name)
                .setClassification(entity.classification)
                .setWeight(entity.weight)
                .setHeight(entity.height)
                .setFemaleRatio(entity.femaleRatio)
                .setVariation(variation)
                .setGen(entity.gen.no)
                .setPrimaryType(
                        dev.cequell.openpkm.main_module.proto.pokemon.TypeResponseDTO.newBuilder()
                                .setTypeUuid(entity.primaryType.id.toString())
                                .setName(entity.primaryType.name)
                                .setSlug(entity.primaryType.slug)
                );

        if(entity.secondaryType != null) {
            resultBuilder
                    .setSecondaryType(
                            dev.cequell.openpkm.main_module.proto.pokemon.TypeResponseDTO.newBuilder()
                                    .setTypeUuid(entity.secondaryType.id.toString())
                                    .setName(entity.secondaryType.name)
                                    .setSlug(entity.secondaryType.slug)
                    );
        }

        return resultBuilder.build();
    }

    public List<ValueText<UUID>> toValueText(
            List<PokemonEntity> entityList,
            PokemonMapTypeEnum typeEnum) {
        return entityList.stream().map(el -> toValueText(el, typeEnum)).collect(Collectors.toList());
    }
    public abstract List<PokemonResponseDto> mapResponse(List<PokemonEntity> entityList);
}
