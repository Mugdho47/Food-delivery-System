package pp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Admin admin = new Admin();

        // Example admin manages menu
        admin.manageMenu(menu);

        System.out.print("Enter your name , phone Number , Address : ");
        String customerName = scanner.nextLine(); // Use nextLine to capture the full name
        Customer customer = new Customer(customerName);

        // Customer placing order
        while (true) {
            menu.displayMenu();
            System.out.print("Enter food item to order (or 'exit' to finish): ");
            String foodName = scanner.nextLine().trim();  // Use nextLine and trim whitespace

            if (foodName.equalsIgnoreCase("exit")) {
                break;
            }

            // Handle the input for food items
            FoodItem item = menu.getFoodItem(foodName);
            if (item != null) {
                customer.getOrder().addFoodItem(item);
                System.out.println(foodName + " added to your order.");
            } else {
                System.out.println("Invalid food item. Try again.");
            }
        }

        // Display the order summary
        customer.getOrder().displayOrder();

        // Save the order to a file
        FileHandler.saveOrderToFile(customer.getOrder());

        // Example admin views the order
        admin.viewOrder(customer);

        // Closing the scanner object at the end of the program
        scanner.close();
    }
}