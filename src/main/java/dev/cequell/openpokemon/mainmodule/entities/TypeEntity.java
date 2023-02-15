package dev.cequell.openpokemon.mainmodule.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "type")
public class TypeEntity {
    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "background_color")
    private String backgroundColor;

    @Column(name = "foreground_color")
    private String foregroundColor;
}
