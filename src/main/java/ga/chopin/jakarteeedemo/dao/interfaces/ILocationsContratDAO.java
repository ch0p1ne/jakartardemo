package ga.chopin.jakarteeedemo.dao.interfaces;

import ga.chopin.jakarteeedemo.services.entities.Locataire;
import ga.chopin.jakarteeedemo.services.entities.LocationsContrat;

import java.util.List;

public interface ILocationsContratDAO {
    void save(LocationsContrat locationsContrat);
    void update(LocationsContrat locationsContrat);
    void delete(Long id);
    List<LocationsContrat> findAll();
}
