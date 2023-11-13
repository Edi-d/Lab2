package DiscountStrategy;

public class PercentageDiscount implements DiscountStrategy{
    @Override
    public float applyDiscount(float totalPrice) {
        return (float) (totalPrice * (1 - 0.1));
    }
}
