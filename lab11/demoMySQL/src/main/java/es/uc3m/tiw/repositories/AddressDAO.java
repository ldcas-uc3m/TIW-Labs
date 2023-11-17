package es.uc3m.tiw.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uc3m.tiw.domains.Address;



public interface AddressDAO extends CrudRepository<Address, Long> {

    public List<Address> findByPostcode(int postcode);
    public List<Address> findByStreet(String street);
}
