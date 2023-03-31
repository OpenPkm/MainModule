package dev.cequell.openpkm.main_module.repositories;

import dev.cequell.openpkm.main_module.entities.PokemonEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PokemonRepository implements PanacheRepositoryBase<PokemonEntity, UUID> {
    public List<PokemonEntity> findAllById(final List<UUID> idList) {
        return findAll().stream().filter(el -> idList.contains(el.id)).toList();
    }
}
