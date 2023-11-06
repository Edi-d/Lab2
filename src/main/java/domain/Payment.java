package domain;

public class Payment {
    private int Id;
    private int price;
    private String method;

    public Payment(int paymentId, int price, String method) {
        this.Id = paymentId;
        this.price = price;
        this.method = method;
    }

    public int getId() {
        return Id;
    }

    public void setId(int paymentId) {
        this.Id = paymentId;
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
