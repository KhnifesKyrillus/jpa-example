package at.kkhnifes.jpa.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Bank.getEmployeesByBankId", query = "SELECT b.name, e.department, e.firstName, e.surname, e.salary FROM Employee e JOIN Bank b on e.bank.id = (:bankId)")
@NamedQuery(name = "Bank.getAllOtherCustomers", query = "SELECT b.name, c.firstName, c.surname, c.salary FROM Customer c LEFT OUTER JOIN Bank b on c.bank.id = (:bankId)")
@NamedQuery(name = "Bank.getAllBankDirectors", query = "SELECT e.department, e.firstName, e.surname, e.salary FROM Employee e JOIN Bank b on e.bank.id = b.id where e.id=b.director.id")
public class Bank {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    private Employee director;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private List<Customer> customers = new ArrayList<>();

    public Bank() {
    }

    public Bank(Employee director, List<Employee> employees, List<Customer> customers) {
        this.director = director;
        this.employees = employees;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getDirector() {
        return director;
    }

    public void setDirector(Employee director) {
        this.director = director;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
