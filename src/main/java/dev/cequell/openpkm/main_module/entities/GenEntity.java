package dev.cequell.openpkm.main_module.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "gen")
@Entity
public class GenEntity extends PanacheEntityBase {
    @Id
    public UUID id;

    @Column(name = "name")
    public String name;

    @Column(name = "no")
    public int no;
}
