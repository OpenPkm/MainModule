package dev.cequell.openpkm.main_module.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "type")
@Entity
public class TypeEntity {
    @Id
    public UUID id;

    @Column(name = "name")
    public String name;

    @Column(name = "slug")
    public String slug;

    @Column(name = "background_color")
    public String backgroundColor;

    @Column(name = "foreground_color")
    public String foregroundColor;
}
