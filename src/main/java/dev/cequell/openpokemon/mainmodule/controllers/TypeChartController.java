package dev.cequell.openpokemon.mainmodule.controllers;

import dev.cequell.openpokemon.mainmodule.enums.TypeChartServiceEnum;
import dev.cequell.openpokemon.mainmodule.services.ITypeChartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumMap;
import java.util.List;

@RequestMapping("/type-chart")
@RestController
public class TypeChartController {
    private final EnumMap<TypeChartServiceEnum, ITypeChartService> service;

    public TypeChartController(
            final List<ITypeChartService> serviceList
    ) {
        service = new EnumMap<>(TypeChartServiceEnum.class);
        serviceList.forEach(el -> service.put(el.type(), el));
    }

    @GetMapping("/attacking")
    public ResponseEntity<?> attacking(
            @RequestParam(name = "gen") String gen,
            @RequestParam(name = "type") String type
    ) {
        return service
                .get(TypeChartServiceEnum.ATTACKING)
                .execute(gen, type);
    }

    @GetMapping("/defending")
    public ResponseEntity<?> defending(
            @RequestParam(name = "gen") String gen,
            @RequestParam(name = "mainType") String mainType,
            @RequestParam(name = "secondaryType", required = false) String secondaryType
    ) {
        return service
                .get(TypeChartServiceEnum.DEFENDING)
                .execute(gen, mainType, secondaryType);
    }
}
