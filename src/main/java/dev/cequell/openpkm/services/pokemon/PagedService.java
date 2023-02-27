package dev.cequell.openpkm.services.pokemon;

import dev.cequell.openpkm.dto.PagedDto;
import dev.cequell.openpkm.dto.PokemonResponseDto;
import dev.cequell.openpkm.maps.PokemonMapper;
import dev.cequell.openpkm.processing.RequestBaseProcess;
import dev.cequell.openpkm.processing.impl.*;
import dev.cequell.openpkm.repositories.PokemonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.UriInfo;

@ApplicationScoped
public class PagedService {
    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;
    private final RequestBaseProcess requestProcess;

    public PagedService(
            final PokemonRepository pokemonRepository,
            final PokemonMapper pokemonMapper
    ) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonMapper = pokemonMapper;

        requestProcess = new NameRequestProcess();
        requestProcess.add(new SortProcessing());
        requestProcess.add(new GenerationRequestProcess());
        requestProcess.add(new ClassificationRequestProcess());
        requestProcess.add(new PrimaryTypeRequestProcess());
        requestProcess.add(new SecondaryTypeRequestProcess());
        requestProcess.add(new NationalNoRequestProcess());
        requestProcess.add(new RegionalNoRequestProcess());
        requestProcess.add(new SomeTypeRequestProcess());
    }

    public PagedDto<PokemonResponseDto> execute(
            final int page,
            final int size,
            final UriInfo uriInfo
    ) {
        var query = requestProcess.process(
                pokemonRepository.streamAll(),
                uriInfo);
        final var offset = page * size;

        final var result = new PagedDto<PokemonResponseDto>();
        result.data = pokemonMapper.mapResponse(query.skip((long) page *size).limit(size).toList());
        result.total = 0;
        result.offset = offset;
        result.page = page;
        return result;
    }
}
