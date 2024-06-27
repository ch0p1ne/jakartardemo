package ga.chopin.jakarteeedemo.dao.implementations;

import ga.chopin.jakarteeedemo.dao.interfaces.IUserDAO;
import ga.chopin.jakarteeedemo.services.entities.User;
import jakarta.persistence.*;
import org.hibernate.annotations.ParamDef;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;
    @Override
    public void save(User user) {
        transaction.begin();

        try {
           entityManager.persist(user);
           transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void update(User user) {
        transaction.begin();

        try {
            entityManager.merge(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long idU) {
        transaction.begin();
        try {
            User user = entityManager.find(User.class, idU);
            entityManager.remove(user);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public List<User> findAll() {
            List<User> users = entityManager.createQuery("from User ").getResultList();
            return users;
    }

    @Override
    public User findById(Long idU) {
        return entityManager.find(User.class, idU);
    }

    @Override
    public User authenticate(String email, String password) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.email=:email and u.password=:password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        if (query.getResultList().isEmpty()) {
            return null;
        }
        User user = query.getSingleResult();
        return user;
    }

    public UserDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jakarteeedemo");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }
}
