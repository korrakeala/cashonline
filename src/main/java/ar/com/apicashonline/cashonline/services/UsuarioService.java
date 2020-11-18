package ar.com.apicashonline.cashonline.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.apicashonline.cashonline.entities.Usuario;
import ar.com.apicashonline.cashonline.repo.UserRepository;

@Service
public class UsuarioService {

    @Autowired
    UserRepository repo;

    public Usuario altaUser(int userId, String firstName, String lastName, String userEmail){
        Usuario u = new Usuario();

        return u;
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
