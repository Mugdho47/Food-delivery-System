package pp;
import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveOrderToFile(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", true))) {
            writer.write("Order Total: " + order.getTotalCost() + " TK\n");
            for (FoodItem item : order.getOrderedItems()) {
                writer.write(item.getName() + " - " + item.getPrice() + " TK\n");
            }
            writer.write("------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Order> loadOrdersFromFile() {
        ArrayList<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Order order = new Order();
                while (!line.equals("------")) {
                    String[] parts = line.split(" - ");
                    if (parts.length == 2) {
                        String foodName = parts[0];
                        int foodPrice = Integer.parseInt(parts[1].replace(" TK", "").trim());
                        order.addFoodItem(new FoodItem(foodName, foodPrice));
                    }
                    line = reader.readLine();
                }
                orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }
}