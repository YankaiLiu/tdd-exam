package com.tw.tdd.exam;

public class Waitress {

    private Locker locker;

    public Waitress(Locker locker) {
        this.locker = locker;
    }

    public Ticket store(Bag bag) {
        return locker.store(bag);
    }
}
