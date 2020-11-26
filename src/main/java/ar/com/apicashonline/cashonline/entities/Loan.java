package ar.com.apicashonline.cashonline.entities;

import java.math.BigDecimal;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.apicashonline.cashonline.repo.UsuarioRepository;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "total")
    private BigDecimal total = new BigDecimal(0);
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private Usuario user;

    @Transient
    private Integer userId;

    @Autowired
    @Transient
    UsuarioRepository uRepo;

    public Loan() {
    }

    public Loan(BigDecimal total, Usuario user) {;
        this.total = total;
        this.user = user;
        this.userId = user.getId();
    }

    public Loan(BigDecimal total, int userId) {
        this.total = total;
        this.user = uRepo.findById(userId);
        this.userId = (Integer)userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserId(Usuario user) {
        this.userId = user.getId();
    }

}
