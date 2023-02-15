package dev.cequell.openpokemon.mainmodule.services.impl;

import dev.cequell.openpokemon.mainmodule.entities.TypeChartEntity;
import dev.cequell.openpokemon.mainmodule.enums.TypeChartServiceEnum;
import dev.cequell.openpokemon.mainmodule.enums.TypeEnum;
import dev.cequell.openpokemon.mainmodule.models.TypeChartResponseVM;
import dev.cequell.openpokemon.mainmodule.repositories.TypeChartRepository;
import dev.cequell.openpokemon.mainmodule.services.ITypeChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TypeChartDefendingService implements ITypeChartService {
    private final TypeChartRepository typeChartRepository;

    @Override
    public TypeChartServiceEnum type() {
        return TypeChartServiceEnum.DEFENDING;
    }

    @Override
    public ResponseEntity<?> execute(Object... params) {
        final var gen = UUID.fromString((String) params[0]);
        final var mainType = TypeEnum.getByName((String) params[1]);
        final var secondaryType = TypeEnum.getByName((String) params[2]);

        if(mainType == null) return ResponseEntity.badRequest().build();
        if(secondaryType == null && params[2] != null) return ResponseEntity.badRequest().build();

        var list = typeChartRepository.findByDexIdAndDefendingTypeId(gen, mainType.getValue());
        if(secondaryType != null) {
            var list2 = typeChartRepository.findByDexIdAndDefendingTypeId(gen, secondaryType.getValue());
            list.forEach(el -> {
                Optional<TypeChartEntity> first = list2.stream()
                        .filter(el2 -> el2.getAttackingTypeId().equals(el.getAttackingTypeId()))
                        .findFirst();
                first.ifPresent(entity -> el.setMultiplier(el.getMultiplier() * entity.getMultiplier()));
            });
        }

        List<TypeChartResponseVM> result = list.stream()
                .map(el -> new TypeChartResponseVM(el.getAttackingType().getName(), el.getMultiplier()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
