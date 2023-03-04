package dev.cequell.openpkm.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pokemon")
@Entity
public class PokemonEntity extends PanacheEntityBase {
    @Id
    public UUID id;

    @Column(name = "national_dex_no")
    public int nationalDexNo;

    @Column(name = "regional_dex_no")
    public int regionalDexNo;

    @Column(name = "name")
    public String name;

    @Column(name = "classification")
    public String classification;

    @Column(name = "weight")
    public float weight;

    @Column(name = "height")
    public float height;

    @Column(name = "female_ratio")
    public Float femaleRatio;

    @Column(name = "variation")
    public String variation;

    @ManyToOne
    @JoinColumn(
        name = "gen_id",
        insertable = false,
        updatable = false
    )
    public GenEntity gen;

    @ManyToOne
    @JoinColumn(
            name = "primary_type_id",
            insertable = false,
            updatable = false
    )
    public TypeEntity primaryType;

    @ManyToOne
    @JoinColumn(
            name = "secondary_type_id",
            insertable = false,
            updatable = false
    )
    public TypeEntity secondaryType;

    @ManyToOne
    @JoinColumn(
            name = "evolves_from",
            insertable = false,
            updatable = false
    )
    public PokemonEntity evolvesFrom;
}
