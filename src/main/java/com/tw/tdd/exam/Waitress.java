package com.tw.tdd.exam;

import exception.StoreException;

public class Waitress {

    private Locker locker;
    private PrimaryRobot primaryRobot;

    public void manage(Locker locker) {
        this.locker = locker;
    }

    public void manage(PrimaryRobot robot) {
        this.primaryRobot = robot;
    }

    public Ticket store(Bag bag) throws StoreException {
        if (bag.getType() == BagType.S) {
            return locker.store(bag);
        } else if (bag.getType() == BagType.M) {
            return primaryRobot.store(bag);
        }
        return null;
    }
}
