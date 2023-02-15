package dev.cequell.openpokemon.mainmodule.viewmodels;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValueTextVM<T> {
    private T value;
    private String label;
}
