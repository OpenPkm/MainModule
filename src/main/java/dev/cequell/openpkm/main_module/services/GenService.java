package dev.cequell.openpkm.main_module.services;

import dev.cequell.openpkm.main_module.dto.GenResponseDto;
import dev.cequell.openpkm.main_module.maps.GenMapper;
import dev.cequell.openpkm.main_module.repositories.GenRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
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
