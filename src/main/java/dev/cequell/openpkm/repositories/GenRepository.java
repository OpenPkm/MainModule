package dev.cequell.openpkm.repositories;

import dev.cequell.openpkm.entities.GenEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GenRepository implements PanacheRepository<GenEntity> {
    public List<GenEntity> findByNo(final int no) {
        return find("no", no).list();
    }
}
