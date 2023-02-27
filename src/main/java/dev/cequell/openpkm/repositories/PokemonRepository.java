package dev.cequell.openpkm.repositories;

import dev.cequell.openpkm.entities.PokemonEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PokemonRepository implements PanacheRepositoryBase<PokemonEntity, UUID> {
}
