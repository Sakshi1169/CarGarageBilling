import java.util.*;

public class GarageService {
    private Map<String, Customer> customersMap;
    private List<Service> availableServices;

    public GarageService() {
        this.customersMap = new HashMap<>();
        this.availableServices = new ArrayList<>();
        loadServices();
    }

    // Load default available services
    private void loadServices() {
        availableServices.add(new Service("Car Wash", 1000));
        availableServices.add(new Service("Puncture", 100));
        availableServices.add(new Service("Tire Replacement", 3000));
        availableServices.add(new Service("Oil Change", 700));
        availableServices.add(new Service("Wheel Alignment", 300));
    }

    // Add new customer
    public void addCustomer(String name, String phone, String carNumber, String model) {
        Car car = new Car(carNumber, model);
        Customer customer = new Customer(name, phone, car);
        customersMap.put(carNumber, customer);
        System.out.println("Customer added successfully.");
    }

    // Create invoice for customer
    public void createInvoice(String carNumber, Scanner sc) {
        if (!customersMap.containsKey(carNumber)) {
            System.out.println("No customer found with car number " + carNumber);
            return;
        }

        Customer customer = customersMap.get(carNumber);
        Invoice invoice = new Invoice(customer);

        System.out.println("\nAvailable Services:");
        for (int i = 0; i < availableServices.size(); i++) {
            System.out.println((i + 1) + ". " + availableServices.get(i).getName()
                    + " - Rs." + availableServices.get(i).getPrice());
        }
        System.out.println("Enter 0 to finish.");

        while (true) {
            System.out.print("Enter service number to add: ");
            int choice = sc.nextInt();
            if (choice == 0) break;

            if (choice > 0 && choice <= availableServices.size()) {
                invoice.addService(availableServices.get(choice - 1));
                System.out.println("Service added.");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        invoice.printInvoice();
    }
}
