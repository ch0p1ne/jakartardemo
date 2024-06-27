package ga.chopin.jakarteeedemo.dao.interfaces;

import ga.chopin.jakarteeedemo.services.entities.LocationUnit;
import ga.chopin.jakarteeedemo.services.entities.Payment;

import java.util.List;

public interface IPaymentDAO {
    void save(Payment payment);
    void update(Payment payment);
    void delete(Long id);
    List<Payment> findAll();
}
