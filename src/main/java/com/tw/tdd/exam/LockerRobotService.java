package com.tw.tdd.exam;

import exception.ExceptionMessages;
import exception.InvalidTicketException;
import exception.StoreException;

public class LockerRobotService {

    public static Ticket getTicket(Bag bag, Locker locker, PrimaryLockerRobot primaryLockerRobot,
                             SuperLockerRobot superLockerRobot) throws StoreException {
        if (bag.getType() == BagType.S) {
            return locker.store(bag);
        } else if (bag.getType() == BagType.M) {
            return primaryLockerRobot.store(bag);
        } else if (bag.getType() == BagType.L) {
            return superLockerRobot.store(bag);
        }
        return null;
    }

    public static Bag getBag(Ticket ticket, Locker locker, PrimaryLockerRobot primaryLockerRobot,
                             SuperLockerRobot superLockerRobot) throws InvalidTicketException {
        if (ticket.getType().equals(BagType.S)) {
            return locker.pickUp(ticket);
        } else if (ticket.getType().equals(BagType.M)) {
            return primaryLockerRobot.pickUp(ticket);
        } else if (ticket.getType().equals(BagType.L)) {
            return superLockerRobot.pickUp(ticket);
        }
        throw new InvalidTicketException(ExceptionMessages.INVALID_TICKET);
    }
}
