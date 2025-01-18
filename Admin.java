package pp;

public class Admin {
    public void viewOrder(Customer customer) {
        System.out.println("Order details for " + customer.getName() + ":");
        customer.getOrder() ;
    }

    public void manageMenu(Menu menu) {
        System.out.println("Managing Menu...");
        menu.displayMenu();
    }
}