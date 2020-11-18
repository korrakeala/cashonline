package ar.com.apicashonline.cashonline.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.apicashonline.cashonline.entities.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer>{

    public Usuario findByUserName(String userName);
    public Usuario findByUserEmail(String email);
    public Usuario findById(int id);

}
