package dev.cequell.openpkm.maps;

import dev.cequell.openpkm.entities.TypeEntity;
import net.bytebuddy.jar.asm.TypeReference;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TypeMapper {
    TypeReference map(TypeEntity entity);
}
