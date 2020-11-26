package ar.com.apicashonline.cashonline.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.apicashonline.cashonline.entities.Loan;
import ar.com.apicashonline.cashonline.entities.Usuario;
import ar.com.apicashonline.cashonline.excepciones.PaginaNoExisteException;
import ar.com.apicashonline.cashonline.excepciones.UsuarioNoExisteException;
import ar.com.apicashonline.cashonline.models.ResultPage;
import ar.com.apicashonline.cashonline.models.request.LoanRequest;
import ar.com.apicashonline.cashonline.models.response.GenericResponse;
import ar.com.apicashonline.cashonline.services.LoanService;
import ar.com.apicashonline.cashonline.services.UsuarioService;

@RestController
public class LoanController {

    @Autowired
    LoanService ls;

    @Autowired
    UsuarioService us;

    @PostMapping("/loans")
    public ResponseEntity<Object> createLoan(@RequestBody LoanRequest req) throws UsuarioNoExisteException {

        GenericResponse r = new GenericResponse();
        try {

            ls.createLoan(req.userId, req.total);

            r.isOk = true;
            r.message = "Préstamo registrado exitosamente.";

            return new ResponseEntity<>(r, HttpStatus.OK);

        } catch (UsuarioNoExisteException e) {

            r.isOk = false;
            r.message = e.getMessage();
            return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("/loans") // loans?page=1&size=5&user_id=1
    public ResponseEntity<Object> getLoansPaginated(Pageable p,
            @RequestParam(name = "user_id", required = false) Integer id)
            throws PaginaNoExisteException, UsuarioNoExisteException {

        GenericResponse r = new GenericResponse();

        try {
            Page<Loan> pag = null;
            List<Loan> loans = new ArrayList<Loan>();

            if (id != null) {
                Usuario u = us.buscarPorId(id);
                pag = ls.getLoansByUserPaginated(u, p);
            } else {
                pag = ls.getLoansPaginated(p);
            }

            if (p.getPageNumber() > pag.getTotalPages()) {
                throw new PaginaNoExisteException("La página ingresada excede la cantidad de páginas existentes.");
            }

            loans = pag.getContent();
            ResultPage rp = new ResultPage(pag.getNumber(), pag.getSize(), pag.getTotalElements());

            for (Loan loan : loans) {
                loan.setUserId(loan.getUser());
            }

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("items", loans);
            response.put("paging", rp);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (PaginaNoExisteException pe) {

            r.isOk = false;
            r.message = pe.getMessage();
            return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);

        } catch (UsuarioNoExisteException ue) {

            r.isOk = false;
            r.message = ue.getMessage();
            return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
        }
    }
}
