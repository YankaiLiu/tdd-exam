package com.tw.tdd.exam;

import exception.ExceptionMessages;
import exception.InvalidTicketException;
import exception.StoreException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class VIPCustomerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_s_ticket_when_vip_save_bag_given_s_bag_and_locker_robot_manage_one_locker_s_and_has_capacity() throws StoreException {

        Locker lockerS = new Locker(LockerType.S, 10);
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manage(lockerS);

        Bag bag = new Bag(BagType.S);
        Ticket ticket = lockerRobotManager.store(bag);
        Assert.assertEquals(LockerType.S, ticket.getType());
    }

    @Test
    public void should_reminder_has_no_capacity_when_vip_save_bag_given_s_bag_and_locker_robot_manage_one_locker_s_and_has_no_capacity() throws StoreException {

        thrown.expect(StoreException.class);
        thrown.expectMessage(ExceptionMessages.HAS_NO_CAPACITY);

        Locker lockerS = new Locker(LockerType.S, 0);
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manage(lockerS);

        lockerRobotManager.store(new Bag(BagType.S));
    }

    @Test
    public void should_return_m_ticket_when_vip_save_bag_given_m_bag_and_locker_robot_manage_one_locker_m_and_has_capacity() throws StoreException {

        Locker lockerM1 = new Locker(LockerType.M, 10);
        Locker lockerM2 = new Locker(LockerType.M, 10);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(lockerM1);
        primaryLockerRobot.manage(lockerM2);

        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manage(primaryLockerRobot);

        Bag bag = new Bag(BagType.M);
        Ticket ticket = lockerRobotManager.store(bag);
        Assert.assertEquals(LockerType.M, ticket.getType());
        Assert.assertTrue(primaryLockerRobot.getLockers().get(0).containBag(ticket));
    }

    @Test
    public void should_reminder_has_no_capacity_when_vip_save_bag_given_m_bag_and_locker_robot_manage_one_locker_m_and_has_no_capacity() throws StoreException {

        thrown.expect(StoreException.class);
        thrown.expectMessage(ExceptionMessages.HAS_NO_CAPACITY);

        Locker lockerM1 = new Locker(LockerType.M, 0);
        Locker lockerM2 = new Locker(LockerType.M, 0);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(lockerM1);
        primaryLockerRobot.manage(lockerM2);

        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manage(primaryLockerRobot);

        lockerRobotManager.store(new Bag(BagType.M));
    }

    @Test
    public void should_return_l_ticket_when_vip_save_bag_given_l_bag_and_locker_robot_manage_one_locker_l_and_has_capacity() throws StoreException {

        Locker lockerL1 = new Locker(LockerType.L, 10);
        Locker lockerL2 = new Locker(LockerType.L, 10);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();
        superLockerRobot.manage(lockerL1);
        superLockerRobot.manage(lockerL2);

        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manage(superLockerRobot);

        lockerRobotManager.store( new Bag(BagType.L));

        Bag bag = new Bag(BagType.L);
        Ticket ticket = lockerRobotManager.store(bag);
        Assert.assertEquals(LockerType.L, ticket.getType());
        Assert.assertTrue(superLockerRobot.getLockers().get(1).containBag(ticket));
    }

    @Test
    public void should_reminder_has_no_capacity_when_vip_save_bag_given_l_bag_and_locker_robot_manage_one_locker_l_and_has_no_capacity() throws StoreException {

        thrown.expect(StoreException.class);
        thrown.expectMessage(ExceptionMessages.HAS_NO_CAPACITY);

        Locker lockerL1 = new Locker(LockerType.L, 0);
        Locker lockerL2 = new Locker(LockerType.L, 0);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();
        superLockerRobot.manage(lockerL1);
        superLockerRobot.manage(lockerL2);

        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manage(superLockerRobot);

        lockerRobotManager.store(new Bag(BagType.L));
    }

    @Test
    public void should_get_bag_when_vip_pick_up_bag_given_valid_s_ticket() throws StoreException,
            InvalidTicketException {

        Locker lockerS = new Locker(LockerType.S, 10);
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manage(lockerS);

        Bag bag = new Bag(BagType.S);
        Ticket ticket = lockerRobotManager.store(bag);
        Bag pickedBag = lockerRobotManager.pickUp(ticket);

        Assert.assertNotNull(pickedBag);
    }

    @Test
    public void should_get_bag_when_vip_pick_up_bag_given_valid_m_ticket() throws StoreException,
            InvalidTicketException {

        Locker lockerM1 = new Locker(LockerType.M, 10);
        Locker lockerM2 = new Locker(LockerType.M, 10);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(lockerM1);
        primaryLockerRobot.manage(lockerM2);

        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manage(primaryLockerRobot);

        Bag bag = new Bag(BagType.M);
        Ticket ticket = lockerRobotManager.store(bag);
        Bag pickedBag = lockerRobotManager.pickUp(ticket);

        Assert.assertNotNull(pickedBag);
    }

}
