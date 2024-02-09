package dev.cequell.openpkm.main_module.repositories;

import dev.cequell.openpkm.main_module.entities.TypeEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class TypeRepository implements PanacheRepositoryBase<TypeEntity, UUID> {
}
