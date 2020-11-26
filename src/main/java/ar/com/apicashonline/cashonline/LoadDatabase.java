ackage ar.com.apicashonline.cashonline;

import java.math.BigDecimal;
import java.math.BigInteger;
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
    // usuarioRepository.deleteAll();

    for (int i = 0; i < 2; i++) {
      logger.info("Preloading "
          + (usuarioRepository.save(new Usuario("prueba" + i + "@prueba11.com", "Juana" + i, "Molina" + i)).toString()));
    }

    logger.info("Preloading Loans...");
    BigDecimal total = new BigDecimal(0);
    int userId = 0;
    int min = 6;
    int max = 230;
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
