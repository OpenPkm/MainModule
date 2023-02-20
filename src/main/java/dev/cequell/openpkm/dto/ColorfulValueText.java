package dev.cequell.openpkm.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColorfulValueText<T> {
    private T value;
    private String label;
    private String foregroundColor;
    private String backgroundColor;
}
