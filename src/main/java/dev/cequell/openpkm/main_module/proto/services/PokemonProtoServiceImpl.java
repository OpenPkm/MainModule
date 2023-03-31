package dev.cequell.openpkm.main_module.proto.services;

import dev.cequell.openpkm.main_module.maps.PokemonMapper;
import dev.cequell.openpkm.main_module.proto.pokemon.PokemonProtoService;
import dev.cequell.openpkm.main_module.proto.pokemon.PokemonRequestProtoDto;
import dev.cequell.openpkm.main_module.proto.pokemon.PokemonResponseProtoDto;
import dev.cequell.openpkm.main_module.repositories.PokemonRepository;
import io.quarkus.grpc.GrpcService;
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
    public Uni<PokemonResponseProtoDto> byId(PokemonRequestProtoDto request) {
        final var idList = request.getPokemonUuidList().stream().map(UUID::fromString).toList();
        final var entityList = pokemonRepository.findAllById(idList);
        return Uni.createFrom().item(
                PokemonResponseProtoDto.newBuilder()
                        .addAllPokemon(pokemonMapper.mapAsProtoResponse(entityList))
                        .build()
        );
    }
}
