package solid.singleresponsibility;

import java.util.ArrayList;
import java.util.List;


/**
 * CustomerService has two responsibilities: managing customers and saving them to a file.
 * If the requirements change, and we need to change the way customers are saved to a database,
 * we will have to modify CustomerService, which violates the SRP. It would be better to move
 * the responsibility of saving customers to a separate class that specializes in this task.
 */
public class CustomerServiceBad {
    private List<Customer> customers;

    public CustomerServiceBad() {
        customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void saveCustomersToFile() {
        // code to save customers to a file
    }
}
