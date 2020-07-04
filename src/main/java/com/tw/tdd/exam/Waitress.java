package com.tw.tdd.exam;

import exception.StoreException;

public class Waitress {

    private Locker locker;

    public Waitress(Locker locker) {
        this.locker = locker;
    }

    public Ticket store(Bag bag) throws StoreException {
        return locker.store(bag);
    }
}
