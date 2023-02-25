package dev.cequell.openpkm.processing;


import dev.cequell.openpkm.entities.PokemonEntity;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
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

    public Stream<PokemonEntity> process(Stream<PokemonEntity> content, UriInfo uriInfo) {
        var result = handle(content, uriInfo.getQueryParameters());
        if(next != null) {
            return next.process(result, uriInfo);
        } else {
            return result;
        }
    }

    protected abstract Stream<PokemonEntity> handle(Stream<PokemonEntity> content, MultivaluedMap<String, String> uriInfo);
}
