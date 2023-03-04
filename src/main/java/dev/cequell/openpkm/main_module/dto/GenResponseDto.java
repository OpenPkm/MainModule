package dev.cequell.openpkm.main_module.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenResponseDto {
    private UUID id;
    private int no;
    private String name;
}
