package com.tw.tdd.exam;

import exception.ExceptionMessages;
import exception.IncorrectLockerTypeException;
import exception.InvalidTicketException;
import exception.StoreException;

import java.util.ArrayList;
import java.util.List;

public class PrimaryLockerRobot {

    private List<Locker> lockers;
    public PrimaryLockerRobot() {
        lockers = new ArrayList<>();
    }

    public void manage(Locker locker) throws IncorrectLockerTypeException {
        if (locker.getType() != LockerType.M) {
            throw new IncorrectLockerTypeException(ExceptionMessages.INCORRECT_LOCKER_TYPE);
        }

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
