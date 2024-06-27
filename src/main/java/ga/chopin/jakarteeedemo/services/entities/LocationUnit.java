package ga.chopin.jakarteeedemo.services.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "location_units")
public class LocationUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_units_id_gen")
    @SequenceGenerator(name = "location_units_id_gen", sequenceName = "location_units_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "immeuble_id")
    private Immeuble immeuble;

    @Column(name = "numero_unit")
    private Integer numeroUnit;

    @Column(name = "nbre_piece")
    private Integer nbrePiece;

    @Column(name = "superficie")
    private Integer superficie;

    @Column(name = "loyer")
    private Integer loyer;

    @OneToMany(mappedBy = "locationUnit")
    private Set<LocationsContrat> locationsContrats = new LinkedHashSet<>();

}