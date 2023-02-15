package dev.cequell.openpokemon.mainmodule.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "dex")
public class DexEntity {
    @Id
    private UUID id;

    @Column(name = "name")
    private String name;
}
