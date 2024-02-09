package dev.cequell.openpkm.main_module.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

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
