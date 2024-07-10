package Question4;

import java.lang.IllegalArgumentException;

// Question 4
public class OrderProcessor {
    private final Database database;
    private final EmailService emailService;
    private final InventorySystem inventorySystem;

    public OrderProcessor(Database database, EmailService emailService, InventorySystem inventorySystem) {
        this.database = database;
        this.emailService = emailService;
        this.inventorySystem = inventorySystem;
    }

    public void processOrder(Order order) {
        checkItemAvailability(order);
        saveOrderToDatabase(order);
        sendOrderConfirmationEmail(order);
        updateInventory(order);
        applyDiscountForLoyalCustomers(order);
    }

    private void checkItemAvailability(Order order) {
        List<Item> items = order.getItems();
        for (Item item : items) {
            if (!inventorySystem.isItemAvailable(item)) {
                throw new IllegalArgumentException(item.getName() + "Is not available in inventory");
            }
        }
    }

    private void saveOrderToDatabase(Order order) {
        database.saveOrder(order);
    }

    private void sendOrderConfirmationEmail(Order order) {
        String message = "Your order has been received and is being processed.";
        emailService.sendEmail(order.getCustomerEmail(), "Order Confirmation", message);
    }

    private void updateInventory(Order order) {
        List<Item> items = order.getItems();
        for (Item item : items) {
            inventorySystem.updateInventory(item, -item.getQuantity());
        }
    }

    private void applyDiscountForLoyalCustomers(Order order) {
        if (order instanceof LoyalCustomerOrder) {
            LoyalCustomerOrder loyalCustomerOrder = (LoyalCustomerOrder) order;
            loyalCustomerOrder.applyDiscount();
        }
    }
}

