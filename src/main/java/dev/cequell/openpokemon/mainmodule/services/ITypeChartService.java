package dev.cequell.openpokemon.mainmodule.services;

import dev.cequell.openpokemon.mainmodule.enums.TypeChartServiceEnum;
import org.springframework.http.ResponseEntity;

public interface ITypeChartService {
    TypeChartServiceEnum type();
    ResponseEntity<?> execute(Object ...params);
}
