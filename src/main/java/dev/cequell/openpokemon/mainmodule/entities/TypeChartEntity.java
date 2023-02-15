package dev.cequell.openpokemon.mainmodule.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "type_chart")
public class TypeChartEntity {
    @Id
    private UUID id;

    @Column(name = "dex_id", insertable=false, updatable=false)
    private UUID dexId;

    @Column(name = "attacking", insertable=false, updatable=false)
    private UUID attackingTypeId;

    @Column(name = "defending", insertable=false, updatable=false)
    private UUID defenderTypeId;

    @Column(name = "multiplier")
    private float multiplier;

    @ManyToOne
    @JoinColumn(name = "dex_id")
    private DexEntity dex;

    @ManyToOne
    @JoinColumn(name = "attacking")
    private TypeEntity attackingType;

    @ManyToOne
    @JoinColumn(name = "defending")
    private TypeEntity defendingType;
}
