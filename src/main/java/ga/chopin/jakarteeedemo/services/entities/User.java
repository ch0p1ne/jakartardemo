package ga.chopin.jakarteeedemo.services.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @ColumnDefault("nextval('users_id_seq'::regclass)")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ColumnDefault("'unknown'")
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @ColumnDefault("'unknown'")
    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @ColumnDefault("'proprietaire'")
    @Column(name = "role", nullable = false, length = 15)
    private String role;

    @ColumnDefault("'Y'")
    @Column(name = "actif", nullable = false, length = 1)
    private String actif;

    @ColumnDefault("'N'")
    @Column(name = "sexe", nullable = false, length = 1)
    private String sexe;

    @Column(name = "email", nullable = true, length = 75)
    private String email;

    @ColumnDefault("''")
    @Column(name = "password", nullable = true, length = 75)
    private String password;

    @ColumnDefault("'1999-06-06'::date")
    @Column(name = "date_naissance", nullable = true)
    private LocalDate dateNaissance;

}