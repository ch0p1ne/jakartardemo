package ga.chopin.jakarteeedemo.services.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "locations_contrats")
public class LocationsContrat {
    @Id
    @ColumnDefault("nextval('locations_contrats_id_seq'::regclass)")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locataire_id", nullable = false)
    private Locataire locataire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_unit_id")
    private LocationUnit locationUnit;

    @ColumnDefault("now()")
    @Column(name = "date_emission", nullable = false)
    private LocalDate dateEmission;

}