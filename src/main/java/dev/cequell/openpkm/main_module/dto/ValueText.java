package dev.cequell.openpkm.main_module.dto;

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
