package dev.cequell.openpkm.services.pokemon;

import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.enums.PokemonMapTypeEnum;
import dev.cequell.openpkm.maps.PokemonMapper;
import dev.cequell.openpkm.processing.RequestBaseProcess;
import dev.cequell.openpkm.processing.impl.*;
import dev.cequell.openpkm.repositories.PokemonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AsValueTextService {
    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;
    private final RequestBaseProcess requestProcess;

    public AsValueTextService(
            final PokemonRepository pokemonRepository,
            final PokemonMapper pokemonMapper
    ) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonMapper = pokemonMapper;

        requestProcess = new NameRequestProcess();
        requestProcess.add(new GenerationRequestProcess());
        requestProcess.add(new ClassificationRequestProcess());
        requestProcess.add(new PrimaryTypeRequestProcess());
        requestProcess.add(new SecondaryTypeRequestProcess());
        requestProcess.add(new NationalNoRequestProcess());
        requestProcess.add(new RegionalNoRequestProcess());
        requestProcess.add(new SomeTypeRequestProcess());
        requestProcess.add(new SortProcessing());
    }

    public List<ValueText<UUID>> execute(String mode, UriInfo uriInfo) {
        var mapTypeEnum = PokemonMapTypeEnum.of(mode);
        if(mapTypeEnum == null) {
            throw new RuntimeException("Select a valid mode: ");
        }

        var query = requestProcess.process(pokemonRepository.streamAll(), uriInfo);
        return pokemonMapper.toValueText(query.toList(), mapTypeEnum);
    }
}
