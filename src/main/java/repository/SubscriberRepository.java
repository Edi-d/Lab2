package repository;

import domain.Subscriber;

public class SubscriberRepository extends Repository<Subscriber>{

    void notifySubscribers() {
        for (Subscriber subscriber : this.getAll()) {
            subscriber.notifySubscriber();
        }
    }

}
