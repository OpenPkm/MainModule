package dev.cequell.openpkm.main_module.services.pokemon;

import dev.cequell.openpkm.main_module.dto.PokemonRequestParamDto;
import dev.cequell.openpkm.main_module.dto.ValueText;
import dev.cequell.openpkm.main_module.enums.PokemonMapTypeEnum;
import dev.cequell.openpkm.main_module.maps.PokemonMapper;
import dev.cequell.openpkm.main_module.processing.RequestBaseProcess;
import dev.cequell.openpkm.main_module.processing.impl.*;
import dev.cequell.openpkm.main_module.repositories.PokemonRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PokemonAsValueTextService {
    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;
    private final RequestBaseProcess requestProcess;

    public PokemonAsValueTextService(
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

    public List<ValueText<UUID>> execute(PokemonMapTypeEnum mode, PokemonRequestParamDto params) {
        var query = requestProcess.process(pokemonRepository.streamAll(), params);
        return pokemonMapper.toValueText(query.toList(), mode);
    }
}
