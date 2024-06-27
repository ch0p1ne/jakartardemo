package ga.chopin.jakarteeedemo.dao.interfaces;

import ga.chopin.jakarteeedemo.services.entities.LocationUnit;

import java.util.List;

public interface ILocationUnitDAO {
    void save(LocationUnit locationUnit);
    void update(LocationUnit locationUnit);
    void delete(Long id);
    List<LocationUnit> findAll();
}
