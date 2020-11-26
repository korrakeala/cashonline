package ar.com.apicashonline.cashonline.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.apicashonline.cashonline.entities.Loan;
import ar.com.apicashonline.cashonline.entities.Usuario;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    public Optional<Loan> findById(Integer id);
    public Loan findByUser(Usuario u);
    Page <Loan> findAll(Pageable p);
    Page <Loan> findByUser(Usuario u, Pageable p);

}
