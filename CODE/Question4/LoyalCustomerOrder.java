package Question4;

//Question 4
public class LoyalCustomerOrder extends Order {

    @Override
    public void applyDiscount() {
        // Appliquer une remise de 10%
        setTotalPrice(getTotalPrice() * 0.9);
    }

}
