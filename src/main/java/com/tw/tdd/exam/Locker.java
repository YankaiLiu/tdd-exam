package com.tw.tdd.exam;

import java.util.HashMap;

public class Locker {

    private String type;
    private int capacity;
    private HashMap<Ticket, Bag> storedBags = new HashMap<>();

    public Locker(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public Ticket store(Bag bag) {
        if (isNotFull()) {
            Ticket ticket =  new Ticket(this.type);
            storedBags.put(ticket,bag);
            return ticket;
        }
        return null;
    }

    public boolean isNotFull() {
        return capacity > 0;
    }
}
