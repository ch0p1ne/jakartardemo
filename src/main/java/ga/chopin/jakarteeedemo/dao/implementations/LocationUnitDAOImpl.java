package ga.chopin.jakarteeedemo.dao.implementations;

import ga.chopin.jakarteeedemo.dao.interfaces.ILocationUnitDAO;
import ga.chopin.jakarteeedemo.services.entities.Locataire;
import ga.chopin.jakarteeedemo.services.entities.LocationUnit;
import ga.chopin.jakarteeedemo.services.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class LocationUnitDAOImpl implements ILocationUnitDAO {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;
    @Override
    public void save(LocationUnit locationUnit) {
        transaction.begin();

        try {
            entityManager.persist(locationUnit);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(LocationUnit locationUnit) {
        transaction.begin();

        try {
            entityManager.merge(locationUnit);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        transaction.begin();
        try {
            LocationUnit locationUnit = entityManager.find(LocationUnit.class, id);
            entityManager.remove(locationUnit);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<LocationUnit> findAll() {
        List<LocationUnit> locationUnit = entityManager.createQuery("from Locataire ").getResultList();
        return locationUnit;
    }

    public LocationUnitDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jakarteeedemo");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }
}
