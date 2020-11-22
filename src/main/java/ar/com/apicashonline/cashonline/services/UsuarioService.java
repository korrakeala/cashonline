package ar.com.apicashonline.cashonline.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.apicashonline.cashonline.entities.Usuario;
import ar.com.apicashonline.cashonline.repo.UserRepository;
import ar.com.apicashonline.cashonline.security.Crypto;

@Service
public class UsuarioService {

    @Autowired
    UserRepository repo;

    public Usuario altaUser(String firstName, String lastName, String userEmail){
        Usuario u = new Usuario();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(userEmail);
        u.setUserName(userEmail);

        String passwordEnTextoClaro;
        String passwordEncriptada;

        // dejo seguridad preparada para implementar password a futuro
        passwordEnTextoClaro = userEmail+lastName;
        passwordEncriptada = Crypto.encrypt(passwordEnTextoClaro, u.getUserName());

        u.setPassword(passwordEncriptada);
        save(u);

        return u;
    }

    public void login(String username, String password) {

        Usuario u = repo.findByUserName(username);

        if (u == null || !u.getPassword().equals(Crypto.encrypt(password, u.getUserName()))) {

            throw new BadCredentialsException("Usuario o contraseña invalida");
        }

    }

    public void save(Usuario u) {
        repo.save(u);
    }

    public List<Usuario> getUsers() {

        return repo.findAll();
    }

    public Usuario buscarPorEmail(String email) {

        return repo.findByUserEmail(email);
    }

    public Usuario buscarPorUserName(String userName) {

        return repo.findByUserName(userName);
    }

    public Usuario buscarPorId(int id) {

        Optional<Usuario> u = Optional.of(repo.findById(id));

        if (u.isPresent())
            return u.get();
        return null;
    }
    
}
