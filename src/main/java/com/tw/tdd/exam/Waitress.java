package com.tw.tdd.exam;

import exception.ExceptionMessages;
import exception.InvalidTicketException;
import exception.StoreException;
import exception.TicketTypeIncorrectException;

public class Waitress {

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
        return LockerRobotService.getTicket(bag, locker, primaryLockerRobot, superLockerRobot);
    }

    public Bag pickUp(Ticket ticket) throws InvalidTicketException {
        return LockerRobotService.getBag(ticket, locker, primaryLockerRobot, superLockerRobot);
    }

    public void makeMistake(Ticket ticket) throws TicketTypeIncorrectException {
        throw new TicketTypeIncorrectException(ExceptionMessages.INCORRECT_TICKET_TYPE);
    }
 }
