package dev.cequell.openpkm.main_module.proto.services;

import dev.cequell.openpkm.main_module.maps.PokemonMapper;
import dev.cequell.openpkm.main_module.proto.pokemon.PokemonProtoService;
import dev.cequell.openpkm.main_module.proto.pokemon.PokemonRequestDto;
import dev.cequell.openpkm.main_module.proto.pokemon.PokemonResponseDto;
import dev.cequell.openpkm.main_module.repositories.PokemonRepository;
import io.quarkus.grpc.GrpcService;
import io.quarkus.logging.Log;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@GrpcService
public class PokemonProtoServiceImpl implements PokemonProtoService {
    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;

    @Override
    @Blocking
    public Uni<PokemonResponseDto> byId(PokemonRequestDto request) {
        Log.info("ARRIVED 1 - ".concat(request.getPokemonUuid()));
        final var pokemonUuid = UUID.fromString(request.getPokemonUuid());
        final var pokemonOpt = pokemonRepository.findByIdOptional(pokemonUuid);
        if(pokemonOpt.isEmpty()) {
            throw new RuntimeException("Not found");
        }

        final var pokemon = pokemonOpt.get();
        Log.info("ARRIVED 2 - ".concat(pokemon.name));

        return Uni.createFrom().item(this.pokemonMapper.mapAsProtoResponse(pokemon));
    }
}