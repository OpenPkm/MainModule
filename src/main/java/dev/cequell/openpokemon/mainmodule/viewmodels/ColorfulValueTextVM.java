package dev.cequell.openpokemon.mainmodule.viewmodels;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColorfulValueTextVM<T> {
    private T value;
    private String label;
    private String backgroundColor;
    private String foregroundColor;
}
