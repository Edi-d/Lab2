package repository;

import domain.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements Repository<Payment>{
    private List <Payment> payments;

    public PaymentRepository(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public void create(Payment entity) {
        payments.add(entity);
    }

    @Override
    public void update(Payment entity) {
    }

    @Override
    public void delete(Payment entity) {
        payments.remove(entity);
    }

    @Override
    public List<Payment> getAll() {
        return new ArrayList<>(payments);
    }
}
