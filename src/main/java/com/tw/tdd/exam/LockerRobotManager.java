package com.tw.tdd.exam;

import exception.ExceptionMessages;
import exception.InvalidTicketException;
import exception.NotVipException;
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

    public Ticket store(Bag bag, VipCard vipCard) throws StoreException, NotVipException {

        if (vipCard == null) {
            throw new NotVipException(ExceptionMessages.IS_NOT_VIP);
        }

        if (bag.getType() == BagType.S) {
            return locker.store(bag);
        } else if (bag.getType() == BagType.M) {
            return primaryLockerRobot.store(bag);
        } else if (bag.getType() == BagType.L) {
            return superLockerRobot.store(bag);
        }
        return null;
    }

    public Bag pickUp(Ticket ticket, VipCard vipCard) throws InvalidTicketException {
        if (ticket.getType() == BagType.S) {
            return locker.pickUp(ticket);
        } else if (ticket.getType() == BagType.M) {
            return primaryLockerRobot.pickUp(ticket);
        } else if (ticket.getType() == BagType.L) {
            return superLockerRobot.pickUp(ticket);
        }
        throw new InvalidTicketException(ExceptionMessages.INVALID_TICKET);
    }
}
