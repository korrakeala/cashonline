package ar.com.apicashonline.cashonline.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.apicashonline.cashonline.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    public User findByUserEmail(String email);
    public User findById(int id);

}
