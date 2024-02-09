package dev.cequell.openpkm.main_module.services.pokemon;

import dev.cequell.openpkm.main_module.dto.PokemonResponseDto;
import dev.cequell.openpkm.main_module.exceptions.InvalidIdException;
import dev.cequell.openpkm.main_module.maps.PokemonMapper;
import dev.cequell.openpkm.main_module.repositories.PokemonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@ApplicationScoped
public class PokemonByIdService {
    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;

    public PokemonResponseDto execute(final UUID id) {
        var result = pokemonRepository.findById(id);
        if(result == null) {
            throw new InvalidIdException(id);
        }

        return pokemonMapper.mapResponse(result);
    }
}
