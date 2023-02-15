package dev.cequell.openpokemon.mainmodule.repositories;

import dev.cequell.openpokemon.mainmodule.entities.TypeChartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TypeChartRepository extends JpaRepository<TypeChartEntity, UUID> {
    List<TypeChartEntity> findByDexIdAndAttackingTypeId(UUID dexId, UUID attackerTypeId);
    List<TypeChartEntity> findByDexIdAndDefendingTypeId(UUID dexId, UUID defenderTypeId);
}
