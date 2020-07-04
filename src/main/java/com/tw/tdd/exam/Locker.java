package com.tw.tdd.exam;

import exception.ExceptionMessages;
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
        return capacity > 0;
    }
}
