package uc3m.tiw.springsecurity.lab1.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import uc3m.tiw.springsecurity.lab1.model.Country;

@Service
public class CountryService {

    private static List<Country> countries;

    public CountryService() {
    	
    	// https://www.baeldung.com/spring-component-repository-service
    	// https://es.stackoverflow.com/questions/174661/diferencia-entre-anotaciones-component-repository-y-service-en-spring/174707
    	
        countries = new LinkedList<>();
        
        countries.add(new Country(1L, "Francia", 1000001,"Europa"));
        countries.add(new Country(2L, "España", 1000002,"Europa"));
        countries.add(new Country(3L, "Alemania", 1000003,"Europa"));
        countries.add(new Country(4L, "Mexico", 1000004, "America"));
        countries.add(new Country(5L, "Holanda", 1000005,"Europa"));
        countries.add(new Country(6L, "Brasil", 1000006,"America"));
        countries.add(new Country(7L, "USA", 1000007,"America"));
        countries.add(new Country(8L, "Canada", 1000008,"America"));
        countries.add(new Country(9L, "Argentina", 1000009,"America"));
        countries.add(new Country(10L, "Portugal", 1000010,"Europa"));
        countries.add(new Country(11L, "Australia", 1000011,"Australia"));
        countries.add(new Country(12L, "Japon", 1000012,"Asia"));

    }

    public Optional<Country> findById(Long id) {
        return countries.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        findById(id).ifPresent(c -> countries.remove(c));
    }

}