package dev.cequell.openpkm.main_module.services.type;

import dev.cequell.openpkm.main_module.dto.TypeResponseDto;
import dev.cequell.openpkm.main_module.maps.TypeMapper;
import dev.cequell.openpkm.main_module.repositories.TypeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@ApplicationScoped
public class TypeAllService {
    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    public List<TypeResponseDto> execute() {
        final var entityList = typeRepository.findAll().list();
        return typeMapper.map(entityList);
    }
}
