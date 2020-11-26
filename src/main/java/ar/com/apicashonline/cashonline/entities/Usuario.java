package ar.com.apicashonline.cashonline.entities;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "user")
public class Usuario {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "loan_id")
    @LazyCollection (LazyCollectionOption.FALSE)
    private List<Loan> loans;

    public Usuario() {
    }

    public Usuario(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Usuario(String email, String firstName, String lastName, List<Loan> loans) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        for (Loan loan : loans) {
            loan.setUserId(loan.getUser());
        }
        this.loans = loans;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Loan> getLoans() {
        for (Loan loan : loans) {
            loan.setUserId(loan.getUser());
        }
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public void addLoan(Loan loan) {
        loan.setUser(this);
        this.loans.add(loan);
    }

    @Override
    public String toString() {
        return "Usuario id: " + id + ", email: " + email + ", firstName: " + firstName + ", lastName: " + lastName + ".";
    }
        
}
