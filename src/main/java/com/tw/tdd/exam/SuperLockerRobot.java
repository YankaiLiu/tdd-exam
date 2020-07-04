package com.tw.tdd.exam;

import exception.ExceptionMessages;
import exception.StoreException;

import java.util.ArrayList;
import java.util.List;

public class SuperLockerRobot {

    private List<Locker> lockers;
    public SuperLockerRobot() {
        lockers = new ArrayList<>();
    }

    public void manage(Locker locker) {
        lockers.add(locker);
    }

    public Ticket store(Bag bag) throws StoreException {

        Locker lockerForSave = null;
        double vacancyRate = 0;
        for (Locker locker : lockers) {
            if (locker.vacancyRate() > vacancyRate) {
                lockerForSave = locker;
            }
        }

        if (lockerForSave != null) {
          return lockerForSave.store(bag);
        }
        throw new StoreException(ExceptionMessages.HAS_NO_CAPACITY);
    }

    public List<Locker> getLockers() {
        return lockers;
    }
}
