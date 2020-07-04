package com.tw.tdd.exam;

import exception.ExceptionMessages;
import exception.InvalidTicketException;
import exception.StoreException;

import java.util.HashMap;

public class Locker {

    private String type;
    private int capacity;
    private HashMap<Ticket, Bag> storedBags = new HashMap<>();

    public Locker(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public Ticket store(Bag bag) throws StoreException {
        if (isNotFull()) {
            Ticket ticket =  new Ticket(this.type);
            storedBags.put(ticket,bag);
            return ticket;
        }
        throw new StoreException(ExceptionMessages.HAS_NO_CAPACITY);
    }

    public boolean isNotFull() {
        return storedBags.size() < capacity;
    }

    public boolean containBag(Ticket ticket) {
        return storedBags.get(ticket) != null;
    }

    public double vacancyRate() {
        //这里的空置率 = 可用容量 / 容量
        if (capacity == 0 || capacity == storedBags.size()) {
            return 0;
        } else if (capacity - storedBags.size() == capacity) {
            return 1;
        }
        return ((double)(capacity - storedBags.size())) /  (double)capacity;
    }

    public Bag pickUp(Ticket ticket) throws InvalidTicketException {
        if (storedBags.get(ticket) != null) {
            return storedBags.get(ticket);
        }

        throw new InvalidTicketException(ExceptionMessages.INVALID_TICKET);
    }
}
