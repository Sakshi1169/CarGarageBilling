import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private Customer customer;
    private List<Service> serviceList;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.serviceList = new ArrayList<>();
    }

    public void addService(Service service) {
        serviceList.add(service);
    }

    public void printInvoice() {
        System.out.println("\n---------------------- Invoice ----------------------");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Car Number: " + customer.getCar().getCarNumber());
        System.out.println("Car Model: " + customer.getCar().getModel());
        System.out.println("\nServices Availed:");

        double total = 0;
        for (Service s : serviceList) {
            System.out.println("- " + s.getName() + " : Rs." + s.getPrice());
            total += s.getPrice();
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Total Amount: Rs." + total);
        System.out.println("----------------------------------------------------");
    }
}
