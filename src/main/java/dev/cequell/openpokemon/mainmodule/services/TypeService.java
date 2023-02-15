package dev.cequell.openpokemon.mainmodule.services;

import dev.cequell.openpokemon.mainmodule.entities.TypeEntity;
import dev.cequell.openpokemon.mainmodule.mappings.TypeMapping;
import dev.cequell.openpokemon.mainmodule.repositories.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TypeService {
    private final TypeRepository typeRepository;
    private final TypeMapping typeMapping;

    public ResponseEntity<List<?>> getAllAsValueText(boolean colorful) {
        List<TypeEntity> typeList = typeRepository.findAll();

        if(colorful) {
            return ResponseEntity.ok(typeMapping.toColorfulValueText(typeList));
        } else {
            return ResponseEntity.ok(typeMapping.toValueText(typeList));
        }
    }
}
