package dev.cequell.openpkm.main_module.repositories;

import dev.cequell.openpkm.main_module.entities.PokemonEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class PokemonRepository implements PanacheRepositoryBase<PokemonEntity, UUID> {
}
