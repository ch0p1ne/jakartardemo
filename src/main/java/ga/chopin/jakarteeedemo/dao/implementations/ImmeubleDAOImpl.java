package ga.chopin.jakarteeedemo.dao.implementations;

import ga.chopin.jakarteeedemo.dao.interfaces.IImmeubleDAO;
import ga.chopin.jakarteeedemo.services.entities.Immeuble;
import ga.chopin.jakarteeedemo.services.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class ImmeubleDAOImpl implements IImmeubleDAO {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;
    @Override
    public void save(Immeuble immeuble) {
        transaction.begin();

        try {
            entityManager.persist(immeuble);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Immeuble immeuble) {
        transaction.begin();

        try {
            entityManager.merge(immeuble);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long idI) {
        transaction.begin();
        try {
            Immeuble immeuble = entityManager.find(Immeuble.class, idI);
            entityManager.remove(immeuble);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Immeuble> findAll() {
        List<Immeuble> immeubles = entityManager.createQuery("from Immeuble ").getResultList();
        return immeubles;
    }

    public ImmeubleDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jakarteeedemo");
       entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }
}
