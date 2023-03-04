package dev.cequell.openpkm.main_module.dto;

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
    private String slug;
    private String backgroundColor;
    private String foregroundColor;
}
