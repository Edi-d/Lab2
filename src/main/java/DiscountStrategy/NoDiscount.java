package DiscountStrategy;

public class NoDiscount implements DiscountStrategy{
    @Override
    public float applyDiscount(float totalPrice) {
        return totalPrice;
    }
}
