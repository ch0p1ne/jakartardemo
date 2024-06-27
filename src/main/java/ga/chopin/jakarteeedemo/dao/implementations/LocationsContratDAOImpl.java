package ga.chopin.jakarteeedemo.dao.implementations;

import ga.chopin.jakarteeedemo.dao.interfaces.ILocationsContratDAO;
import ga.chopin.jakarteeedemo.services.entities.LocationsContrat;
import ga.chopin.jakarteeedemo.services.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class LocationsContratDAOImpl implements ILocationsContratDAO {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;
    @Override
    public void save(LocationsContrat locationsContrat) {
        transaction.begin();

        try {
            entityManager.persist(locationsContrat);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(LocationsContrat locationsContrat) {
        transaction.begin();

        try {
            entityManager.merge(locationsContrat);
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
            LocationsContrat locationsContrat = entityManager.find(LocationsContrat.class, id);
            entityManager.remove(locationsContrat);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<LocationsContrat> findAll() {
        List<LocationsContrat> locationsContrat = entityManager.createQuery("from LocationsContrat ").getResultList();
        return locationsContrat;
    }

    public LocationsContratDAOImpl() {
            entityManagerFactory = Persistence.createEntityManagerFactory("jakarteeedemo");
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
    }
}
