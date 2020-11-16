package ar.com.apicashonline.cashonline.entities;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String userEmail;
    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "loan_id", referencedColumnName = "loan_id")
    @LazyCollection (LazyCollectionOption.FALSE)
    private List<Loan> loans = new ArrayList<Loan>();


    public User() {
    }

    public User(int userId, String firstName, String lastName, String userEmail, List<Loan> loans) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.loans = loans;
    }

    public User(int userId, String firstName, String lastName, String userEmail) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;

    }

    

    
}
