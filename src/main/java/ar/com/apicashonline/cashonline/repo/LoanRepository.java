package ar.com.apicashonline.cashonline.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.apicashonline.cashonline.entities.Loan;
import ar.com.apicashonline.cashonline.entities.User;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{

    public Loan findById(int id);
    public Loan findByUser(User u);

}
