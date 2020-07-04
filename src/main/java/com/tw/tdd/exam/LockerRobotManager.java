package com.tw.tdd.exam;

import exception.StoreException;

public class LockerRobotManager {

    private Locker locker;
    private PrimaryLockerRobot primaryLockerRobot;
    private SuperLockerRobot superLockerRobot;

    public void manage(Locker locker) {
        this.locker = locker;
    }

    public void manage(PrimaryLockerRobot robot) {
        this.primaryLockerRobot = robot;
    }

    public void manage(SuperLockerRobot robot) {
        this.superLockerRobot = robot;
    }

    public Ticket store(Bag bag) throws StoreException {
        if (bag.getType() == BagType.S) {
            return locker.store(bag);
        } else if (bag.getType() == BagType.M) {
            return primaryLockerRobot.store(bag);
        } else if (bag.getType() == BagType.L) {
            return superLockerRobot.store(bag);
        }
        return null;
    }
}
