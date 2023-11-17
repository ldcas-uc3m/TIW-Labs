package es.uc3m.tiw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uc3m.tiw.repositories.AddressDAO;
import es.uc3m.tiw.repositories.UserDAO;
import es.uc3m.tiw.domains.User;
import es.uc3m.tiw.domains.Address;



@RestController
@CrossOrigin
public class MyController {
    @Autowired
    UserDAO daoUS;

    @Autowired
    AddressDAO daoAD;

    /* GET */
    
    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return daoUS.findAll();
    }

    @RequestMapping("/users/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return daoUS.findByName(name);
    }

    @RequestMapping("/users/{name}/{surname}")
    public List<User> getUserByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
        return daoUS.findByNameAndSurname(name, surname);
    }

    @RequestMapping("/userstreet/{street}")
    public List<User> getUserByStreet(@PathVariable String street) {
        return daoUS.findByAddressStreet(street);
    }

    @RequestMapping("/address/{streetName}")
    public List<Address> getAddress(@PathVariable String streetName) {
        return daoAD.findByStreet(streetName);
    }


    /* POST */

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public User saveUser(@RequestBody @Validated User puser) {
        return daoUS.save(puser);
    }


    /* DELETE */

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public void deleteUser(@PathVariable @Validated Long id) {
        User us = daoUS.findById(id).orElse(null);
        if (us != null) {
            daoUS.delete(us);
        }

    }


    /* PUT */

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
    public User updateUser(@PathVariable @Validated Long id, @RequestBody @Validated User puser) {
        User us = daoUS.findById(id).orElse(null);

        if (us != null) {
            us.setName(puser.getName());
            us.setSurname(puser.getSurname());
            daoUS.delete(us);
        }

        return daoUS.save(puser);
    }

}
