package at.kkhnifes.jpa;

import at.kkhnifes.jpa.model.Bank;
import at.kkhnifes.jpa.model.Customer;
import at.kkhnifes.jpa.model.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
@Path("/bank")
public class BankService {
    @Inject
    DatabaseRepository repo;

    @Path("criteriaQuery")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Object[]> criteriaQueryExample() {
        return repo.criteriaQueryExample();
    }

    @Path("getEmployeesByBankId")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object[]> getEmployeesByBankId() {
        return repo.getEmployeesByBankId();
    }

    @Path("getNotDirectors")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object[]> getNotDirectors() {
        return repo.getNotDirectors();
    }

    @Path("getAllBankDirectors")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object[]> getAllBankDirectors() {
        return repo.getAllBankDirectors();
    }
}
