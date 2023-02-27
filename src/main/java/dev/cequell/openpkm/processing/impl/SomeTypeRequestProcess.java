package dev.cequell.openpkm.processing.impl;

import dev.cequell.openpkm.entities.PokemonEntity;
import dev.cequell.openpkm.processing.RequestBaseProcess;

import javax.ws.rs.core.MultivaluedMap;
import java.util.stream.Stream;

public class SomeTypeRequestProcess extends RequestBaseProcess {
    @Override
    protected Stream<PokemonEntity> handle(Stream<PokemonEntity> content, MultivaluedMap<String, String> params) {
        var type = params.getFirst("type");
        if(type == null) return content;
        return content.filter(
                el -> type.equals(el.primaryType.slug) ||
                (el.secondaryType != null && type.equals(el.secondaryType.slug))
        );
    }
}
