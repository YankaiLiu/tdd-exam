package com.tw.tdd.exam;
import org.junit.Assert;
import org.junit.Test;

public class NormalCustomerTest {

    @Test
    public void should_return_s_ticket_when_save_bag_given_s_bag_and_waiter_manage_two_lcoker_and_all_has_capacity() {

        Locker lockerS = new Locker(LockerType.S, 10);
        Waitress waitress = new Waitress(lockerS);

        Bag bag = new Bag(BagType.S);
        Ticket ticket = waitress.store(bag);
        Assert.assertEquals(LockerType.S, ticket.getType());
    }
}
