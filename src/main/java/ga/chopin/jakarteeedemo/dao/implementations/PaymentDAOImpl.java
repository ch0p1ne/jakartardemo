package ga.chopin.jakarteeedemo.dao.implementations;

import ga.chopin.jakarteeedemo.dao.interfaces.IPaymentDAO;
import ga.chopin.jakarteeedemo.services.entities.LocationUnit;
import ga.chopin.jakarteeedemo.services.entities.Payment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class PaymentDAOImpl implements IPaymentDAO {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;
    @Override
    public void save(Payment payment) {
        transaction.begin();

        try {
            entityManager.persist(payment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Payment payment) {
        transaction.begin();

        try {
            entityManager.merge(payment);
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
            Payment payment = entityManager.find(Payment.class, id);
            entityManager.remove(payment);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Payment> findAll() {
        List<Payment> payment = entityManager.createQuery("from Payment ").getResultList();
        return payment;
    }

    public PaymentDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jakarteeedemo");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }
}
