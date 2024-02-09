package dev.cequell.openpkm.main_module.repositories;

import dev.cequell.openpkm.main_module.entities.GenEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class GenRepository implements PanacheRepository<GenEntity> {
    public List<GenEntity> findByNo(final int no) {
        return find("no", no).list();
    }
}
