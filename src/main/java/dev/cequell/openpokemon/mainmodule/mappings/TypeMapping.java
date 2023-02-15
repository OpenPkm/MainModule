package dev.cequell.openpokemon.mainmodule.mappings;

import dev.cequell.openpokemon.mainmodule.entities.TypeEntity;
import dev.cequell.openpokemon.mainmodule.viewmodels.ColorfulValueTextVM;
import dev.cequell.openpokemon.mainmodule.viewmodels.ValueTextVM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface TypeMapping {
    @Mapping(target = "label", source = "name")
    @Mapping(target = "value", source = "id")
    ValueTextVM<UUID> toValueText(TypeEntity entity);

    @Mapping(target = "label", source = "name")
    @Mapping(target = "value", source = "id")
    ColorfulValueTextVM<UUID> toColorfulValueText(TypeEntity entity);

    List<ValueTextVM<UUID>> toValueText(List<TypeEntity> entity);
    List<ColorfulValueTextVM<UUID>> toColorfulValueText(List<TypeEntity> entity);
}
