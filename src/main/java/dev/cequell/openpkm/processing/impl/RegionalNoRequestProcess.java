package dev.cequell.openpkm.processing.impl;

import dev.cequell.openpkm.entities.PokemonEntity;
import dev.cequell.openpkm.processing.RequestBaseProcess;

import javax.ws.rs.core.MultivaluedMap;
import java.util.stream.Stream;

public class RegionalNoRequestProcess extends RequestBaseProcess {
    @Override
    protected Stream<PokemonEntity> handle(Stream<PokemonEntity> content, MultivaluedMap<String, String> params) {
        var regionalNo = params.getFirst("regionalNo");
        if(regionalNo == null) return content;
        return content.filter(el -> el.regionalDexNo == Integer.parseInt(regionalNo));
    }
}
