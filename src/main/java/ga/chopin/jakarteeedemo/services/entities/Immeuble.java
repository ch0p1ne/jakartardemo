package ga.chopin.jakarteeedemo.services.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "immeubles")
public class Immeuble {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "immeubles_id_gen")
    @SequenceGenerator(name = "immeubles_id_gen", sequenceName = "immeubles_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 75)
    private String name;

    @Column(name = "adresse", length = 150)
    private String adresse;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "proprietaire_id")
    private User proprietaire;

    @ColumnDefault("0")
    @Column(name = "nbre_unit", nullable = false)
    private Integer nbreUnit;

    @OneToMany(mappedBy = "immeuble")
    private Set<LocationUnit> locationUnits = new LinkedHashSet<>();

}