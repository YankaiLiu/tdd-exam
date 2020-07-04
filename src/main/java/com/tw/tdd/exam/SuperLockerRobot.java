package com.tw.tdd.exam;

import exception.ExceptionMessages;
import exception.IncorrectLockerTypeException;
import exception.InvalidTicketException;
import exception.StoreException;

import java.util.ArrayList;
import java.util.List;

public class SuperLockerRobot {

    private List<Locker> lockers;
    public SuperLockerRobot() {
        lockers = new ArrayList<>();
    }

    public void manage(Locker locker) throws IncorrectLockerTypeException {
        if (locker.getType() != LockerType.L) {
            throw new IncorrectLockerTypeException(ExceptionMessages.INCORRECT_LOCKER_TYPE);
        }
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

    public Bag pickUp(Ticket ticket) throws InvalidTicketException {
        for (Locker locker : lockers) {
            try {
                return locker.pickUp(ticket);
            } catch (InvalidTicketException e) {
                continue;
            }
        }

        throw new InvalidTicketException(ExceptionMessages.INVALID_TICKET);
    }
}
