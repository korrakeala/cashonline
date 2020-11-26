package ar.com.apicashonline.cashonline.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.apicashonline.cashonline.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByEmail(String email);
    public Optional<Usuario> findById(Integer id);
    public Usuario findById(int id);

}
