package ar.com.apicashonline.cashonline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.apicashonline.cashonline.entities.Usuario;
import ar.com.apicashonline.cashonline.excepciones.UsuarioExisteException;
import ar.com.apicashonline.cashonline.excepciones.UsuarioNoExisteException;
import ar.com.apicashonline.cashonline.models.request.AltaRequest;
import ar.com.apicashonline.cashonline.models.response.GenericResponse;
import ar.com.apicashonline.cashonline.services.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService us;

    @PostMapping("/users")
    public ResponseEntity<Object> postRegisterUser(@RequestBody AltaRequest req) throws UsuarioExisteException {
        GenericResponse r = new GenericResponse();

        try {
            Usuario usuarioCreado = us.altaUser(req.firstName, req.lastName, req.email);

            r.isOk = true;
            r.message = "Usuario id: " + usuarioCreado.getId() + " creado con éxito.";
            return new ResponseEntity<>(r, HttpStatus.CREATED);

        } catch (UsuarioExisteException e) {

            r.isOk = false;
            r.message = e.getMessage();
            return new ResponseEntity<>(r, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/users")
    public List<Usuario> getUsers() {
        List<Usuario> lu = us.getUsers();

        return lu;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable int id) throws UsuarioNoExisteException {
        GenericResponse r = new GenericResponse();
        try {

            Usuario u = us.buscarPorId(id);
            return new ResponseEntity<>(u, HttpStatus.OK);

        } catch (UsuarioNoExisteException e) {

            r.isOk = false;
            r.message = e.getMessage();
            return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> bajaUsuario(@PathVariable int id) throws UsuarioNoExisteException {

        GenericResponse r = new GenericResponse();

        try {
            us.bajaUsuario(id);

            r.isOk = true;
            r.message = "Usuario id: " + id + " dado de baja.";
            return new ResponseEntity<>(r, HttpStatus.OK);

        } catch (UsuarioNoExisteException e) {

            r.isOk = false;
            r.message = e.getMessage();
            return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
        }
    }

}
