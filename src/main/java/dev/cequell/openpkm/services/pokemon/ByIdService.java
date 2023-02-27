package dev.cequell.openpkm.services.pokemon;

import dev.cequell.openpkm.dto.PokemonResponseDto;
import dev.cequell.openpkm.maps.PokemonMapper;
import dev.cequell.openpkm.repositories.PokemonRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@RequiredArgsConstructor
@ApplicationScoped
public class ByIdService {
    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;

    public PokemonResponseDto execute(final UUID id) {
        var result = pokemonRepository.findById(id);
        if(result == null) {
            throw new RuntimeException("Pokemon id '%s' not found".formatted(id));
        }

        return pokemonMapper.mapResponse(result);
    }
}
