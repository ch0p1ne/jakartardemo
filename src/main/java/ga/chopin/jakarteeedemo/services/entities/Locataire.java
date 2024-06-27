package ga.chopin.jakarteeedemo.services.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "locataires")
public class Locataire {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locataires_id_gen")
    @SequenceGenerator(name = "locataires_id_gen", sequenceName = "locataires_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ColumnDefault("'unknown'")
    @Column(name = "first_name", nullable = false, length = 35)
    private String firstName;

    @ColumnDefault("'unknown'")
    @Column(name = "last_name", nullable = false, length = 35)
    private String lastName;

    @ColumnDefault("0")
    @Column(name = "nbr_location", nullable = false)
    private Integer nbrLocation;

    @ColumnDefault("'chomage'")
    @Column(name = "emploie", nullable = false, length = 150)
    private String emploie;

    @ColumnDefault("'N'")
    @Column(name = "sexe", nullable = false, length = 1)
    private String sexe;

    @ColumnDefault("'1999-06-06'::date")
    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

    @OneToMany(mappedBy = "locataire")
    private Set<LocationsContrat> locationsContrats = new LinkedHashSet<>();

}