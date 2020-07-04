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
       return LockerRobotService.getTicket(bag, locker, primaryLockerRobot, superLockerRobot);
    }

    public Bag pickUp(Ticket ticket, VipCard vipCard) throws InvalidTicketException, NotVipException {
        if (vipCard == null) {
            throw new NotVipException(ExceptionMessages.IS_NOT_VIP);
        }
        return LockerRobotService.getBag(ticket, locker, primaryLockerRobot, superLockerRobot);
    }
}
