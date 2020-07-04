package com.tw.tdd.exam;
import exception.ExceptionMessages;
import exception.StoreException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NormalCustomerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_s_ticket_when_save_bag_given_s_bag_and_waiter_manage_one_lockerS_and_has_capacity() throws StoreException {

        Locker lockerS = new Locker(LockerType.S, 10);
        Waitress waitress = new Waitress(lockerS);

        Bag bag = new Bag(BagType.S);
        Ticket ticket = waitress.store(bag);
        Assert.assertEquals(LockerType.S, ticket.getType());
    }

    @Test
    public void should_reminder_locker_is_full_when_save_bag_given_s_bag_and_waiter_manage_one_lockerS_and_has_no_capacity() throws StoreException {

        thrown.expect(StoreException.class);
        thrown.expectMessage(ExceptionMessages.HAS_NO_CAPACITY);

        Locker lockerS = new Locker(LockerType.S, 0);
        Waitress waitress = new Waitress(lockerS);

        Bag bag = new Bag(BagType.S);
        waitress.store(bag);
    }
}
