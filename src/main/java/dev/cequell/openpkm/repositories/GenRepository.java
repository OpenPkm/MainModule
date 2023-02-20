package dev.cequell.openpkm.repositories;

import dev.cequell.openpkm.entities.GenEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GenRepository implements PanacheRepository<GenEntity> {
}
