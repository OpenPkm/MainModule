package dev.cequell.openpokemon.mainmodule.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeChartResponseVM {
    private String type;
    private float  multiplier;
}
