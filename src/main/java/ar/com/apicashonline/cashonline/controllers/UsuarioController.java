package ar.com.apicashonline.cashonline.controllers;

import java.security.Principal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.apicashonline.cashonline.services.*;
import ar.com.apicashonline.cashonline.entities.*;
import ar.com.apicashonline.cashonline.models.request.RegistrationRequest;
import ar.com.apicashonline.cashonline.models.response.RegistrationResponse;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService userService;

    @PostMapping("/users")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req) {
        RegistrationResponse r = new RegistrationResponse();

        Usuario usuarioCreado = userService.altaUser(req.firstName, req.lastName, req.email);

        r.isOk = true;
        r.message = "Usuario creado con éxito.";
        r.usuarioId = usuarioCreado.getUserId();
        return r;
    }

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
