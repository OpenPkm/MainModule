package dev.cequell.openpkm.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    @Column(name = "name")
    private String name;

    @Column(name = "classification")
    private String classification;

    @Column(name = "weight")
    private float weight;

    @Column(name = "height")
    private float height;

    @Column(name = "female_ratio")
    private float femaleRatio;

    @Column(name = "variation")
    private String variation;
}
