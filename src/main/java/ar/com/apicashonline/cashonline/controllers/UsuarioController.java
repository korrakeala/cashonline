package ar.com.apicashonline.cashonline.controllers;

import java.security.Principal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.com.apicashonline.cashonline.services.*;
import ar.com.apicashonline.cashonline.entities.*;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService userService;

    @GetMapping("/users")
    public List<Usuario> getUsers(Principal principal) {
        List<Usuario> lu = userService.getUsers();

        return lu;
    }

    @GetMapping("/users/{id}")
    public Usuario getUserById(@PathVariable int id, Principal principal) {
        Usuario u = userService.buscarPorId(id);

        return u;
    }
    
}
