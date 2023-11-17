package es.uc3m.tiw.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uc3m.tiw.domains.User;



public interface UserDAO extends CrudRepository<User, Long> {
    // define queries

    public List<User> findAll();

    public List<User> findByName(String name);
    public List<User> findTop1ByName(String name);
    public List<User> findByNameAndSurname(String name, String surname);
    public List<User> findByAddressStreet(String streetname);

}
