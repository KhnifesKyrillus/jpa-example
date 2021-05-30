package at.kkhnifes.jpa.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String iban;

    private String bic;
    private Double balance;

    @ManyToMany(mappedBy = "accounts", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Customer> customers = new ArrayList<>();

    public Account() {
    }

    public Account(String iban, String bic, Double balance, List<Customer> customers) {
        this.iban = iban;
        this.bic = bic;
        this.balance = balance;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
