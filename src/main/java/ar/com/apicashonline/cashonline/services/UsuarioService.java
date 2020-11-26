package ar.com.apicashonline.cashonline.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.apicashonline.cashonline.entities.Usuario;
import ar.com.apicashonline.cashonline.excepciones.UsuarioExisteException;
import ar.com.apicashonline.cashonline.excepciones.UsuarioNoExisteException;
import ar.com.apicashonline.cashonline.repo.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    public Usuario altaUser(String firstName, String lastName, String userEmail) throws UsuarioExisteException {
        Usuario u = new Usuario();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(userEmail);

        for (Usuario usuarioExistente : repo.findAll()) {
            if (userEmail.equals(usuarioExistente.getEmail()))
            throw new UsuarioExisteException("Ya existe un usuario registrado con ese e-mail. Por favor ingrese uno diferente.");
        }

        save(u);

        return u;
    }

    public void save(Usuario u) {
        repo.save(u);
    }

    public List<Usuario> getUsers() {

        return repo.findAll();
    }

    public Usuario buscarPorId(Integer id) throws UsuarioNoExisteException {

        Optional<Usuario> u = repo.findById(id);

        if (u.isPresent())
            return u.get();
        throw new UsuarioNoExisteException("No existe usuario con el id " + id);
    }

    public void bajaUsuario(Integer id) throws UsuarioNoExisteException {

        Usuario u = this.buscarPorId(id);
        repo.delete(u);
        
    }
    
}
