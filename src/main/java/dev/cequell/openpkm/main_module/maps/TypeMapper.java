package dev.cequell.openpkm.main_module.maps;

import dev.cequell.openpkm.main_module.entities.TypeEntity;
import net.bytebuddy.jar.asm.TypeReference;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TypeMapper {
    TypeReference map(TypeEntity entity);
}
