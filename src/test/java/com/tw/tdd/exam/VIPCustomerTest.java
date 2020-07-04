package com.tw.tdd.exam;

import exception.StoreException;
import org.junit.Assert;
import org.junit.Test;

public class VIPCustomerTest {

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

}
