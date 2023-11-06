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
    public void add(Payment entity) {
        payments.add(entity);
    }

    @Override
    public void update(Payment entity) {
    }

    @Override
    public void deleteById(int id) {
        payments.removeIf(payments -> payments.getId() == id);
    }

    @Override
    public List<Payment> getAll() {
        return new ArrayList<>(payments);
    }
}
