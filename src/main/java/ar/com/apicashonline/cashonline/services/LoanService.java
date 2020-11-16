package ar.com.apicashonline.cashonline.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.apicashonline.cashonline.entities.Loan;
import ar.com.apicashonline.cashonline.repo.LoanRepository;

@Service
public class LoanService {

    @Autowired
    LoanRepository repo;

    public void save(Loan l){
        repo.save(l);
    }

    public List<Loan> getLoans() {

        return repo.findAll();
    }
    
}
