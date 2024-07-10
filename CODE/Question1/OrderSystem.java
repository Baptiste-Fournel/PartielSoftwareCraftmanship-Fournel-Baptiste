package Question1;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

// Question 1
public class OrderSystem {
    private final Map<Integer, List<String>> orderList = new HashMap<>();
    public void addNewOrder(Integer customerID, String itemName) {
        orderList.computeIfAbsent(customerID, k -> new ArrayList<>()).add(itemName);
    }

    public void modifyOrder(Integer customerID, Integer itemIndex, String newItemName) {
        List<String> items = orderList.get(customerID);
        if (items != null && isValidIndex(itemIndex, items.size())) {
            items.set(itemIndex, newItemName);
        }
    }

    public void removeOrder(Integer customerID, Integer itemIndex) {
        List<String> items = orderList.get(customerID);
        if (items != null && isValidIndex(itemIndex, items.size())) {
            items.remove(itemIndex.intValue());
        }
    }

    public void printOrders() {
        for (Map.Entry<Integer, List<String>> entry : orderList.entrySet()) {
            System.out.println("Customer ID: " + entry.getKey());
            System.out.println("Items: " + String.join(", ", entry.getValue()));
            System.out.println();
        }
    }

    private boolean isValidIndex(int index, int size) {

        return index >= 0 && index < size;
    }
}