package dev.cequell.openpkm.processing.impl;

import dev.cequell.openpkm.entities.PokemonEntity;
import dev.cequell.openpkm.processing.RequestBaseProcess;

import javax.ws.rs.core.MultivaluedMap;
import java.util.stream.Stream;

public class SortProcessing extends RequestBaseProcess {
    @Override
    protected Stream<PokemonEntity> handle(Stream<PokemonEntity> content, MultivaluedMap<String, String> params) {
        final var sortBy = params.getFirst("sortBy")==null?
                "nationalDexNo" :
                params.getFirst("sortBy");
        final var desc = params.getFirst("reverse")==null?
                1 :
                Boolean.getBoolean(params.getFirst("reverse")) ? -1 : 1;

        return content.sorted((lhs, rhs) -> desc * switch (sortBy) {
            case "regionalDexNo" -> lhs.regionalDexNo-rhs.regionalDexNo;
            case "name" -> lhs.name.compareTo(rhs.name);
            case "gen" -> lhs.gen.no-rhs.gen.no;
            case "weight" -> (int) Math.signum(lhs.weight-rhs.weight);
            case "height" -> (int) Math.signum(lhs.height-rhs.height);
            default -> lhs.nationalDexNo-rhs.nationalDexNo;
        });
    }
}
