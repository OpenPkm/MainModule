package dev.cequell.openpkm.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeResponseDto {
    private UUID id;
    private String name;
    private String backgroundColor;
    private String foregroundColor;
}
