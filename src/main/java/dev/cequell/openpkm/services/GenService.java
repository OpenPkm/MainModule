package dev.cequell.openpkm.services;

import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.maps.GenMapper;
import dev.cequell.openpkm.repositories.GenRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@ApplicationScoped
public class GenService {
    private final GenRepository genRepository;
    private final GenMapper genMapper;

    public List<ValueText<UUID>> getAllAsValueText() {
        return genMapper.toValueText(genRepository.listAll());
    }
}
