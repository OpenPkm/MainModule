package dev.cequell.openpkm.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonResponseDto {
    private UUID id;
    private int nationalDexNo;
    private int regionalDexNo;
    private String name;
    private String classification;
    private float weight;
    private float height;
    private float femaleRatio;
    private String variation;
    private GenResponseDto gen;
    private TypeResponseDto primaryType;
    private TypeResponseDto secondaryType;
    private PokemonResponseDto evolvesFrom;
}
