package pp;

import java.util.ArrayList;

public class Order {
    private ArrayList<FoodItem> orderedItems;
    private int totalCost;

    public Order() {
        orderedItems = new ArrayList<>();
        totalCost = 0;
    }

    public void addFoodItem(FoodItem item) {
        orderedItems.add(item);
        totalCost += item.getPrice();
    }

    public int getTotalCost() {
        return totalCost;
    }

    // Add this method to return the list of ordered items
    public ArrayList<FoodItem> getOrderedItems() {
        return orderedItems;
    }

    public void displayOrder() {
        System.out.println("Your Order:");
        for (FoodItem item : orderedItems) {
            System.out.println(item);
        }
        System.out.println("Total Cost: " + totalCost + " TK");
    }
}