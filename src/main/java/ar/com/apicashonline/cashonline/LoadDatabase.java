package ar.com.apicashonline.cashonline;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ar.com.apicashonline.cashonline.entities.Loan;
import ar.com.apicashonline.cashonline.entities.Usuario;
import ar.com.apicashonline.cashonline.repo.LoanRepository;
import ar.com.apicashonline.cashonline.repo.UsuarioRepository;

@Component
public class LoadDatabase implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private LoanRepository loanRepository;

  @Override
  public void run(String... args) throws Exception {

    int cantUsersACrear = 2;
    // lleno tabla user
    for (int i = 0; i < cantUsersACrear; i++) {
      long nroUnico = new Date().getTime();
      logger.info("Preloading "
          + (usuarioRepository.save(new Usuario(nroUnico + "@p.com", "Juana" + i, "Stark" + i)).toString()));
    }

    // lleno tabla loan
    logger.info("Preloading Loans...");
    BigDecimal total = new BigDecimal(0);
    int userId = 0;
    int min = 6; // para evitar problemas con ids vacíos antes de ese
    int max = 230; // en DB local usaría (int)usuarioRepository.count(); pero ClearDB en 
    // Heroku hace los inserts con gaps de 10 entre pk y pk, y no se puede modificar
    Random random = new Random();
    int cantLoans = 10;

    for (int i = 0; i < cantLoans; i++) {
      total = new BigDecimal(BigInteger.valueOf(random.nextInt(1000001)), 2);
      userId = min + random.nextInt(max);
      Usuario user = usuarioRepository.findById(userId);
      loanRepository.save(new Loan(total, user));
    }

    logger.info(cantLoans + " Loans preloaded successfully.");
  }
}
