package dev.cequell.openpkm.processing;


import dev.cequell.openpkm.dto.PokemonRequestParamDto;
import dev.cequell.openpkm.entities.PokemonEntity;

import java.util.stream.Stream;

public abstract class RequestBaseProcess {
    private RequestBaseProcess next;

    public void add(RequestBaseProcess impl) {
        if(next == null) {
            next = impl;
        } else {
            next.add(impl);
        }
    }

    public Stream<PokemonEntity> process(Stream<PokemonEntity> content, final PokemonRequestParamDto params) {
        if(params == null) return content;

        var result = handle(content, params);
        if(next != null) {
            return next.process(result, params);
        } else {
            return result;
        }
    }

    protected abstract Stream<PokemonEntity> handle(Stream<PokemonEntity> content, final PokemonRequestParamDto params);
}
