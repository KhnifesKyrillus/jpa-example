package at.kkhnifes.jpa;

import at.kkhnifes.jpa.model.Account;
import at.kkhnifes.jpa.model.Bank;
import at.kkhnifes.jpa.model.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class DatabaseRepository {

    @Inject
    private EntityManager em;

    public Collection<Object[]> criteriaQueryExample() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = cb.createQuery(Object[].class);

        Root<Bank> b = q.from(Bank.class);
        Join<Account, Customer> join = b.join("director");
        q.multiselect(b.get("name"), join.get("firstName"), join.get("surname"));
        q.groupBy(b.get("name"));
        q.having(cb.gt(cb.count(join.get("id")), 1));
        TypedQuery<Object[]> query = em.createQuery(q);
        return query.getResultList();
    }

    public List<Object[]> getEmployeesByBankId() {
        return em.createNamedQuery("Bank.getEmployeesByBankId", Object[].class)
                .setParameter("bankId", Long.valueOf(2)).getResultList();
    }

    public List<Object[]> getNotDirectors() {
        return em.createNamedQuery("Employee.getNotDirectors", Object[].class).getResultList();
    }

    public List<Object[]> getAllBankDirectors() {
        return em.createNamedQuery("Bank.getAllBankDirectors", Object[].class).getResultList();
    }
}
