package solid.singleresponsibility;

import java.util.List;

/**
 * CustomerService is responsible for managing customers.
 * Each class has only one responsibility, and if one of them changes, it won't affect the other.
 */
public class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getCustomers() {
        return repository.getCustomers();
    }

    public void addCustomer(Customer customer) {
        repository.addCustomer(customer);
    }
}

