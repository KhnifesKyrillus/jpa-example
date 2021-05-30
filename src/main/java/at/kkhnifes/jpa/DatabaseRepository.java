package at.kkhnifes.jpa;

import at.kkhnifes.jpa.model.Account;
import at.kkhnifes.jpa.model.Customer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.Collection;

public class DatabaseRepository {

    @Inject
    private EntityManager em;

    public Collection<Customer> criteriaQueryExample() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> q = cb.createQuery(Customer.class);
        Root<Customer> c = q.from(Customer.class);
        Join<Account, Customer> joinAccountCustomer = c.join("accounts");
        q.multiselect(c.get("firstName"), c.get("surname"), cb.max(c.get("salary")));
        q.having(cb.gt(cb.count(c.get("id")), 2));
        TypedQuery<Customer> query = em.createQuery(q);
        return query.getResultList();

    }
}
