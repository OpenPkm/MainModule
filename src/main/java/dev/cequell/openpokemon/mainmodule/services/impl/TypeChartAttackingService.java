package dev.cequell.openpokemon.mainmodule.services.impl;

import dev.cequell.openpokemon.mainmodule.enums.TypeChartServiceEnum;
import dev.cequell.openpokemon.mainmodule.enums.TypeEnum;
import dev.cequell.openpokemon.mainmodule.models.TypeChartResponseVM;
import dev.cequell.openpokemon.mainmodule.repositories.TypeChartRepository;
import dev.cequell.openpokemon.mainmodule.services.ITypeChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TypeChartAttackingService implements ITypeChartService {
    private final TypeChartRepository typeChartRepository;

    @Override
    public TypeChartServiceEnum type() {
        return TypeChartServiceEnum.ATTACKING;
    }

    @Override
    public ResponseEntity<?> execute(Object... params) {
        final var gen = UUID.fromString((String) params[0]);
        final var attackerType = TypeEnum.getByName((String) params[1]);

        if(attackerType == null) return ResponseEntity.badRequest().build();

        var list = typeChartRepository.findByDexIdAndAttackingTypeId(gen, attackerType.getValue());

        List<TypeChartResponseVM> result = list.stream()
                .map(el -> new TypeChartResponseVM(el.getDefendingType().getName(), el.getMultiplier()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
