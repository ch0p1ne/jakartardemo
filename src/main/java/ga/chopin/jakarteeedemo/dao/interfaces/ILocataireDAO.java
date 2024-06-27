package ga.chopin.jakarteeedemo.dao.interfaces;

import ga.chopin.jakarteeedemo.services.entities.Locataire;

import java.util.List;

public interface ILocataireDAO {
    void save(Locataire locataire);
    void update(Locataire locataire);
    void delete(Long id);
    List<Locataire> findAll();
}
