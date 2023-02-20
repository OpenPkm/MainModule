package dev.cequell.openpkm.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValueText<T> {
    private T value;
    private String label;
}
