import java.util.*;

public class GarageBillingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GarageService garageService = new GarageService();

        while (true) {
            System.out.println("\n---------------------------- Bharati Car Service Center ----------------------------");
            System.out.println("1. Add Customer");
            System.out.println("2. Create Invoice");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone number: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Car number: ");
                    String carNum = sc.nextLine();
                    System.out.print("Enter Car Model: ");
                    String model = sc.nextLine();
                    garageService.addCustomer(name, phone, carNum, model);
                    break;

                case 2:
                    System.out.print("Enter the Car Number: ");
                    String carNumInvoice = sc.nextLine();
                    garageService.createInvoice(carNumInvoice, sc);
                    break;

                case 3:
                    System.out.println("Thank you for visiting Bharati Car Service Center!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
