package dev.cequell.openpokemon.mainmodule.controllers;

import dev.cequell.openpokemon.mainmodule.services.TypeService;
import jakarta.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("types/")
@RestController
public class TypeController {
    private final TypeService typeService;

    @GetMapping("AsValueText")
    public ResponseEntity<?> AsValueText(
            @QueryParam(value = "colorful") boolean colorful
    ) {
        return typeService.getAllAsValueText(colorful);
    }

}
