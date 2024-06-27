package ga.chopin.jakarteeedemo.dao.interfaces;

import ga.chopin.jakarteeedemo.services.entities.Immeuble;

import java.util.List;

public interface IImmeubleDAO {
    void save(Immeuble immeuble);
    void update(Immeuble immeuble);
    void delete(Long idI);
    List<Immeuble> findAll();
}
