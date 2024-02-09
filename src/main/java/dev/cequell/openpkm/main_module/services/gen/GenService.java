package dev.cequell.openpkm.main_module.services.gen;

import dev.cequell.openpkm.main_module.dto.GenResponseDto;
import dev.cequell.openpkm.main_module.maps.GenMapper;
import dev.cequell.openpkm.main_module.repositories.GenRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@ApplicationScoped
public class GenService {
    private final GenRepository genRepository;
    private final GenMapper genMapper;

    public List<GenResponseDto> getAll() {
        return genMapper.toResponseDto(genRepository.listAll());
    }
}
