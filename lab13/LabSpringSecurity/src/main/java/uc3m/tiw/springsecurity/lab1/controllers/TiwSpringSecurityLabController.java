package uc3m.tiw.springsecurity.lab1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uc3m.tiw.springsecurity.lab1.model.Country;
import uc3m.tiw.springsecurity.lab1.services.CountryService;

@RestController
@RequestMapping(value="/country")
public class TiwSpringSecurityLabController {

    private final CountryService countryService;

    public TiwSpringSecurityLabController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/{id}/")
    public ResponseEntity<Country> getById(@PathVariable("id") Long id) {

        printUser(SecurityContextHolder.getContext().getAuthentication());
        return countryService.findById(id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id, Authentication authentication) {
        printUser(authentication);
        countryService.deleteById(id);
    }

    private void printUser(Authentication authentication) {
        authentication.getAuthorities().forEach(a -> System.out.println(a.getAuthority()));
        System.out.println(authentication.getName());
    }
}
