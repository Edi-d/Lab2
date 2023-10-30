package domain;

public class Payment {
    private int paymentId;
    private int price;
    private String method;

    public Payment(int paymentId, int price, String method) {
        this.paymentId = paymentId;
        this.price = price;
        this.method = method;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
