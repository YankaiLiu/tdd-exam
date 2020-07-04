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
    public void should_return_s_ticket_when_save_bag_given_s_bag_and_waitress_manage_one_lockerS_and_has_capacity() throws StoreException {

        Locker lockerS = new Locker(LockerType.S, 10);
        Waitress waitress = new Waitress();
        waitress.manage(lockerS);

        Bag bag = new Bag(BagType.S);
        Ticket ticket = waitress.store(bag);
        Assert.assertEquals(LockerType.S, ticket.getType());
    }

    @Test
    public void should_reminder_locker_is_full_when_save_bag_given_s_bag_and_waitress_manage_one_lockerS_and_has_no_capacity() throws StoreException {

        thrown.expect(StoreException.class);
        thrown.expectMessage(ExceptionMessages.HAS_NO_CAPACITY);

        Locker lockerS = new Locker(LockerType.S, 0);
        Waitress waitress = new Waitress();
        waitress.manage(lockerS);

        waitress.store(new Bag(BagType.S));
    }

    @Test
    public void should_return_m_ticket_and_save_into_1st_locker_when_save_bag_given_m_bag_and_waitress_manage_primary_robot_locker_and_robot_manage_two_m_locker_and_all_has_capacity() throws StoreException {

        Locker lockerM1 = new Locker(LockerType.M, 10);
        Locker lockerM2 = new Locker(LockerType.M, 10);
        PrimaryRobot primaryRobot = new PrimaryRobot();
        primaryRobot.manage(lockerM1);
        primaryRobot.manage(lockerM2);

        Waitress waitress = new Waitress();
        waitress.manage(primaryRobot);

        Bag bag = new Bag(BagType.M);
        Ticket ticket = waitress.store(bag);
        Assert.assertEquals(LockerType.M, ticket.getType());
        Assert.assertTrue(primaryRobot.getLockers().get(0).containBag(ticket));
    }

    @Test
    public void should_return_m_ticket_and_save_into_2nd_locker_when_save_bag_given_m_bag_and_waitress_manage_primary_robot_locker_and_robot_manage_two_m_locker_and_1st_is_full_2nd_has_capacity() throws StoreException {

        Locker lockerM1 = new Locker(LockerType.M, 0);
        Locker lockerM2 = new Locker(LockerType.M, 10);
        PrimaryRobot primaryRobot = new PrimaryRobot();
        primaryRobot.manage(lockerM1);
        primaryRobot.manage(lockerM2);

        Waitress waitress = new Waitress();
        waitress.manage(primaryRobot);

        Bag bag = new Bag(BagType.M);
        Ticket ticket = waitress.store(bag);
        Assert.assertEquals(LockerType.M, ticket.getType());
        Assert.assertTrue(primaryRobot.getLockers().get(1).containBag(ticket));
    }

    @Test
    public void should_reminder_has_no_capacity_when_save_bag_given_m_bag_and_waitress_manage_primary_robot_locker_and_robot_manage_two_m_locker_and_all_lockers_has_no_capacity() throws StoreException {

        thrown.expect(StoreException.class);
        thrown.expectMessage(ExceptionMessages.HAS_NO_CAPACITY);

        Locker lockerM1 = new Locker(LockerType.M, 0);
        Locker lockerM2 = new Locker(LockerType.M, 0);
        PrimaryRobot primaryRobot = new PrimaryRobot();
        primaryRobot.manage(lockerM1);
        primaryRobot.manage(lockerM2);

        Waitress waitress = new Waitress();
        waitress.manage(primaryRobot);

        waitress.store(new Bag(BagType.M));
    }



}
