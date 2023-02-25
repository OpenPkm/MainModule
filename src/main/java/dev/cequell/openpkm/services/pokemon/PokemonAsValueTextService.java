package dev.cequell.openpkm.services.pokemon;

import dev.cequell.openpkm.dto.ValueText;
import dev.cequell.openpkm.maps.PokemonMapper;
import dev.cequell.openpkm.processing.impl.*;
import dev.cequell.openpkm.repositories.PokemonRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@ApplicationScoped
public class PokemonAsValueTextService {
    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;

    public List<ValueText<UUID>> execute(UriInfo uriInfo) {
        var requestProcess = new NameRequestProcess();
        var generationProcess = new GenerationRequestProcess();
        var classificationProcess = new ClassificationRequestProcess();
        var primaryTypeProcess = new PrimaryTypeRequestProcess();
        var secondaryTypeProcess = new SecondaryTypeRequestProcess();

        requestProcess.add(generationProcess);
        requestProcess.add(classificationProcess);
        requestProcess.add(primaryTypeProcess);
        requestProcess.add(secondaryTypeProcess);

        var query = requestProcess.process(pokemonRepository.streamAll(), uriInfo);
        return pokemonMapper.toValueText(query.toList());
    }
}
