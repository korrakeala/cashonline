package ar.com.apicashonline.cashonline.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.com.apicashonline.cashonline.entities.Loan;
import ar.com.apicashonline.cashonline.entities.Usuario;
import ar.com.apicashonline.cashonline.excepciones.UsuarioNoExisteException;
import ar.com.apicashonline.cashonline.repo.LoanRepository;

@Service
public class LoanService {

    @Autowired
    LoanRepository repo;

    @Autowired
    UsuarioService usuarioService;

    public void save(Loan l) {
        repo.save(l);
    }

    public List<Loan> getLoans() {

        return (List<Loan>) repo.findAll();
    }

    public Page<Loan> getLoansPaginated(Pageable p) {

        return repo.findAll(p);
    }

    public Page<Loan> getLoansByUserPaginated(Usuario user, Pageable p) {

        return repo.findByUser(user, p);
    }

    public void createLoan(Integer id, BigDecimal total) throws UsuarioNoExisteException {

        Usuario u = usuarioService.buscarPorId(id);

        if (u != null) {
            Loan p = new Loan();
            p.setTotal(total);
            p.setUser(u);
            p.setUserId(u);
            save(p);
            u.addLoan(p);
        }

    }
    
}
