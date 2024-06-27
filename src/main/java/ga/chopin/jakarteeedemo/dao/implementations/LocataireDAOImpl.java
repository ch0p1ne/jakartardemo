package ga.chopin.jakarteeedemo.dao.implementations;

import ga.chopin.jakarteeedemo.dao.interfaces.ILocataireDAO;
import ga.chopin.jakarteeedemo.services.entities.Locataire;
import ga.chopin.jakarteeedemo.services.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class LocataireDAOImpl implements ILocataireDAO {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;
    @Override
    public void save(Locataire locataire) {
        transaction.begin();

        try {
            entityManager.persist(locataire);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Locataire locataire) {
        transaction.begin();

        try {
            entityManager.merge(locataire);
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
            Locataire locataire = entityManager.find(Locataire.class, id);
            entityManager.remove(locataire);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Locataire> findAll() {
            List<Locataire> locataire = entityManager.createQuery("from Locataire ").getResultList();
            return locataire;
    }

    public LocataireDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jakarteeedemo");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }
}
