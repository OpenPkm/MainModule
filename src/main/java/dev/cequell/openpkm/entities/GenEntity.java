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
@Table(name = "gen")
@Entity
public class GenEntity extends PanacheEntityBase {
    @Id
    private UUID id;

    @Column(name = "name")
    private String name;
}
