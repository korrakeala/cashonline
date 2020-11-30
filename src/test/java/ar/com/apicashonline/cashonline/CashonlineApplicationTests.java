package ar.com.apicashonline.cashonline;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.apicashonline.cashonline.entities.Loan;
import ar.com.apicashonline.cashonline.entities.Usuario;
import ar.com.apicashonline.cashonline.services.LoanService;
import ar.com.apicashonline.cashonline.services.UsuarioService;
import ar.com.apicashonline.cashonline.services.LoanService.LoanValidationType;
import ar.com.apicashonline.cashonline.services.UsuarioService.UserValidationType;

@SpringBootTest
class CashonlineApplicationTests {

	@Autowired
	UsuarioService userService;

	@Autowired
	LoanService loanService;

	@Test
	void contextLoads() {
	}

	@Test
	void verifyUserData() {

		Usuario user = new Usuario();
		UserValidationType validationType = userService.verifyUser(user);
		assertEquals(UserValidationType.USER_INVALID_DATA, validationType);
	}

	@Test
	void verifyDuplicatedUser() {

		Usuario user = new Usuario();
		user.setFirstName("Guillermo");
		user.setLastName("Francella");
		user.setEmail("user@test.com");

		UserValidationType validationType = userService.verifyUser(user);
		assertEquals(UserValidationType.USER_DUPLICATED, validationType);

	}

	@Test
	void verifyNonDuplicatedUser() {

		Usuario user = new Usuario();
		user.setFirstName("Paola");
		user.setLastName("Argento");
		user.setEmail("test1@app.com.ar");

		UserValidationType validationType = userService.verifyUser(user);
		assertEquals(UserValidationType.USER_OK, validationType);

	}

	@Test
	void verifyCorrectLoanData(){
		Loan loan = new Loan();
		loan.setTotal(new BigDecimal(2500));

		LoanValidationType validationType = loanService.verifyLoan(loan);
		assertEquals(LoanValidationType.LOAN_OK, validationType);
	}

}
