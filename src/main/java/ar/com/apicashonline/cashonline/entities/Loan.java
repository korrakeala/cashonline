package ar.com.apicashonline.cashonline.entities;

import java.math.BigDecimal;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;
    @Column(name = "total")
    private BigDecimal total = new BigDecimal(0);
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private Usuario user;

    public Loan() {
    }

    public Loan(int loanId, BigDecimal total, Usuario user) {
        this.loanId = loanId;
        this.total = total;
        this.user = user;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
        this.user.getLoans().add(this);
    }

}
