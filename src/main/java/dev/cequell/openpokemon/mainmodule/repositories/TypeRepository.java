package dev.cequell.openpokemon.mainmodule.repositories;

import dev.cequell.openpokemon.mainmodule.entities.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, UUID> {
}
