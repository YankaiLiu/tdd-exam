package com.tw.tdd.exam;

import exception.ExceptionMessages;
import exception.StoreException;

import java.util.ArrayList;
import java.util.List;

public class PrimaryRobot {

    private List<Locker> lockers;
    public PrimaryRobot() {
        lockers = new ArrayList<>();
    }

    public void manage(Locker locker) {
        lockers.add(locker);
    }

    public Ticket store(Bag bag) throws StoreException {

        for (Locker locker : lockers) {
            if (locker.isNotFull()) {
               return  locker.store(bag);
            }
        }

        throw new StoreException(ExceptionMessages.HAS_NO_CAPACITY);
    }

    public List<Locker> getLockers() {
        return lockers;
    }
}
