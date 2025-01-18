package pp;
import java.util.ArrayList;

public class Menu {
    private ArrayList<FoodItem> foodItems;

    public Menu() {
        foodItems = new ArrayList<>();
        foodItems.add(new FoodItem("Rice", 20));
        foodItems.add(new FoodItem("Fish", 80));
        foodItems.add(new FoodItem("Chicken", 80));
        foodItems.add(new FoodItem("Chicken Polao", 120));
        foodItems.add(new FoodItem("Kacchi Biriyani", 150));
        foodItems.add(new FoodItem("Burger", 100));
        foodItems.add(new FoodItem("Pizza", 250));
        foodItems.add(new FoodItem("Sandwich", 40));
        foodItems.add(new FoodItem("Fried Rice", 60));
    }

    public void displayMenu() {
        System.out.println("Available Food Items:");
        for (FoodItem item : foodItems) {
            System.out.println(item);
        }
    }

    public FoodItem getFoodItem(String name) {
        for (FoodItem item : foodItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}