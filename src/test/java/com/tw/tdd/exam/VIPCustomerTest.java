package com.tw.tdd.exam;

import exception.StoreException;
import org.junit.Assert;
import org.junit.Test;

public class VIPCustomerTest {

    @Test
    public void should_return_s_ticket_when_vip_save_bag_given_s_bag_and_locker_robot_manage_one_lockerS_and_has_capacity() throws StoreException {

        Locker lockerS = new Locker(LockerType.S, 10);
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manage(lockerS);

        Bag bag = new Bag(BagType.S);
        Ticket ticket = lockerRobotManager.store(bag);
        Assert.assertEquals(LockerType.S, ticket.getType());
    }

}
