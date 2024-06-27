package ga.chopin.jakarteeedemo.dao.interfaces;

import ga.chopin.jakarteeedemo.services.entities.User;

import java.util.List;

public interface IUserDAO {
    void save(User user);
    void update(User user);
    void delete(Long idU);
    List<User> findAll();
    User findById(Long idU);
    User authenticate(String username, String password);
}
