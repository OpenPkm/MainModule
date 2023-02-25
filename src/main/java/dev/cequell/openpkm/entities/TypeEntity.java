package dev.cequell.openpkm.entities;

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
@Table(name = "type")
@Entity
public class TypeEntity {
    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "slug")
    private String slug;

    @Column(name = "background_color")
    private String backgroundColor;

    @Column(name = "foreground_color")
    private String foregroundColor;
}
