package solid.singleresponsibility;

import java.util.ArrayList;
import java.util.List;


/**
 * This class has single responsibility of performing CRUD operations for the Customer.
 * CustomerRepository is responsible for managing the persistence of customers.
 * Each class has only one responsibility, and if one of them changes, it won't affect the other.
 */
public class CustomerRepository {
    private List<Customer> customers;

    public CustomerRepository() {
        customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
