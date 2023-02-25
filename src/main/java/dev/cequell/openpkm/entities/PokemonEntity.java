package dev.cequell.openpkm.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pokemon")
@Entity
public class PokemonEntity extends PanacheEntityBase {
    @Id
    private UUID id;

    @Column(name = "national_dex_no")
    private int nationalDexNo;

    @Column(name = "regional_dex_no")
    private int regionalDexNo;

    @Column(name = "name")
    private String name;

    @Column(name = "classification")
    private String classification;

    @Column(name = "weight")
    private float weight;

    @Column(name = "height")
    private float height;

    @Column(name = "female_ratio")
    private Float femaleRatio;

    @Column(name = "variation")
    private String variation;

    @ManyToOne
    @JoinColumn(
        name = "gen_id",
        insertable = false,
        updatable = false
    )
    private GenEntity gen;

    @ManyToOne
    @JoinColumn(
            name = "primary_type_id",
            insertable = false,
            updatable = false
    )
    private TypeEntity primaryType;

    @ManyToOne
    @JoinColumn(
            name = "secondary_type_id",
            insertable = false,
            updatable = false
    )
    private TypeEntity secondaryType;
}
