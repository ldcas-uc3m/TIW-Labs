package uc3m.tiw.springsecurity.lab1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test")
public class TiwSpringSecurityLabTestController {

    //@PreAuthorize("isAuthenticated()")
    @GetMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void testEndpoint() {
        // noting
    }

}
