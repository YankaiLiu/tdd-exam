package com.tw.tdd.exam;
import exception.*;
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
    public void should_return_m_ticket_and_save_into_1st_locker_when_save_bag_given_m_bag_and_waitress_manage_primary_robot_locker_and_robot_manage_two_m_locker_and_all_has_capacity() throws StoreException, IncorrectLockerTypeException {

        Locker lockerM1 = new Locker(LockerType.M, 10);
        Locker lockerM2 = new Locker(LockerType.M, 10);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(lockerM1);
        primaryLockerRobot.manage(lockerM2);

        Waitress waitress = new Waitress();
        waitress.manage(primaryLockerRobot);

        Bag bag = new Bag(BagType.M);
        Ticket ticket = waitress.store(bag);
        Assert.assertEquals(LockerType.M, ticket.getType());
        Assert.assertTrue(primaryLockerRobot.getLockers().get(0).containBag(ticket));
    }

    @Test
    public void should_return_m_ticket_and_save_into_2nd_locker_when_save_bag_given_m_bag_and_waitress_manage_primary_robot_locker_and_robot_manage_two_m_locker_and_1st_is_full_2nd_has_capacity() throws StoreException, IncorrectLockerTypeException {

        Locker lockerM1 = new Locker(LockerType.M, 0);
        Locker lockerM2 = new Locker(LockerType.M, 10);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(lockerM1);
        primaryLockerRobot.manage(lockerM2);

        Waitress waitress = new Waitress();
        waitress.manage(primaryLockerRobot);

        Bag bag = new Bag(BagType.M);
        Ticket ticket = waitress.store(bag);
        Assert.assertEquals(LockerType.M, ticket.getType());
        Assert.assertTrue(primaryLockerRobot.getLockers().get(1).containBag(ticket));
    }

    @Test
    public void should_reminder_has_no_capacity_when_save_bag_given_m_bag_and_waitress_manage_primary_robot_locker_and_robot_manage_two_m_locker_and_all_lockers_has_no_capacity() throws StoreException, IncorrectLockerTypeException {

        thrown.expect(StoreException.class);
        thrown.expectMessage(ExceptionMessages.HAS_NO_CAPACITY);

        Locker lockerM1 = new Locker(LockerType.M, 0);
        Locker lockerM2 = new Locker(LockerType.M, 0);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(lockerM1);
        primaryLockerRobot.manage(lockerM2);

        Waitress waitress = new Waitress();
        waitress.manage(primaryLockerRobot);

        waitress.store(new Bag(BagType.M));
    }

    @Test
    public void should_return_l_ticket_and_save_into_the_locker_which_one_has_bigger_variance_rate_when_save_bag_given_l_bag_and_waitress_manage_super_robot_locker_and_robot_manage_two_l_locker() throws StoreException, IncorrectLockerTypeException {


        Locker lockerL1 = new Locker(LockerType.L, 10);
        Locker lockerL2 = new Locker(LockerType.L, 10);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();
        superLockerRobot.manage(lockerL1);
        superLockerRobot.manage(lockerL2);

        Waitress waitress = new Waitress();
        waitress.manage(superLockerRobot);

        waitress.store( new Bag(BagType.L));

        Bag bag = new Bag(BagType.L);
        Ticket ticket = waitress.store(bag);
        Assert.assertEquals(LockerType.L, ticket.getType());
        Assert.assertTrue(superLockerRobot.getLockers().get(1).containBag(ticket));
    }

    @Test
    public void should_reminder_has_no_capacity_when_save_bag_given_l_bag_and_waitress_manage_super_robot_locker_and_robot_manage_two_l_locker_and_all_lockers_has_no_capacity() throws StoreException, IncorrectLockerTypeException {

        thrown.expect(StoreException.class);
        thrown.expectMessage(ExceptionMessages.HAS_NO_CAPACITY);

        Locker lockerL1 = new Locker(LockerType.L, 0);
        Locker lockerL2 = new Locker(LockerType.L, 0);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();
        superLockerRobot.manage(lockerL1);
        superLockerRobot.manage(lockerL2);

        Waitress waitress = new Waitress();
        waitress.manage(superLockerRobot);

        waitress.store( new Bag(BagType.L));
    }

    @Test
    public void should_get_bag_when_pick_up_bag_given_valid_s_ticket() throws StoreException, InvalidTicketException {

        Locker lockerS = new Locker(LockerType.S, 10);
        Waitress waitress = new Waitress();
        waitress.manage(lockerS);

        Bag bag = new Bag(BagType.S);
        Ticket ticket = waitress.store(bag);
        Bag pickedBag = waitress.pickUp(ticket);

        Assert.assertNotNull(pickedBag);
    }

    @Test
    public void should_get_bag_when_pick_up_bag_given_valid_m_ticket() throws StoreException, InvalidTicketException, IncorrectLockerTypeException {

        Locker lockerM1 = new Locker(LockerType.M, 10);
        Locker lockerM2 = new Locker(LockerType.M, 10);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(lockerM1);
        primaryLockerRobot.manage(lockerM2);

        Waitress waitress = new Waitress();
        waitress.manage(primaryLockerRobot);

        Bag bag = new Bag(BagType.M);
        Ticket ticket = waitress.store(bag);
        Bag pickedBag = waitress.pickUp(ticket);

        Assert.assertNotNull(pickedBag);
    }

    @Test
    public void should_get_bag_when_pick_up_bag_given_valid_l_ticket() throws StoreException, InvalidTicketException, IncorrectLockerTypeException {

        Locker lockerL1 = new Locker(LockerType.L, 10);
        Locker lockerL2 = new Locker(LockerType.L, 10);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();
        superLockerRobot.manage(lockerL1);
        superLockerRobot.manage(lockerL2);

        Waitress waitress = new Waitress();
        waitress.manage(superLockerRobot);

        waitress.store( new Bag(BagType.L));

        Bag bag = new Bag(BagType.L);
        Ticket ticket = waitress.store(bag);
        Bag pickedBag = waitress.pickUp(ticket);

        Assert.assertNotNull(pickedBag);
    }

    @Test
    public void should_reminder_ticket_type_is_incorrect_when_pick_up_bag_given_valid_ticket_but_incorrect_ticket_type() throws StoreException,
            InvalidTicketException, TicketTypeIncorrectException, IncorrectLockerTypeException {


        thrown.expect(TicketTypeIncorrectException.class);
        thrown.expectMessage(ExceptionMessages.INCORRECT_TICKET_TYPE);

        Locker lockerL1 = new Locker(LockerType.L, 10);
        Locker lockerL2 = new Locker(LockerType.L, 10);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();
        superLockerRobot.manage(lockerL1);
        superLockerRobot.manage(lockerL2);

        Waitress waitress = new Waitress();
        waitress.manage(superLockerRobot);

        Bag bag = new Bag(BagType.L);
        Ticket ticket = waitress.store(bag);

        waitress.makeMistake(ticket);
    }

    @Test
    public void should_reminder_invalid_ticket_when_pick_up_bag_given_invalid_ticket() throws StoreException,
            InvalidTicketException, IncorrectLockerTypeException {


        thrown.expect(InvalidTicketException.class);
        thrown.expectMessage(ExceptionMessages.INVALID_TICKET);

        Locker lockerL1 = new Locker(LockerType.L, 10);
        Locker lockerL2 = new Locker(LockerType.L, 10);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();
        superLockerRobot.manage(lockerL1);
        superLockerRobot.manage(lockerL2);

        Waitress waitress = new Waitress();
        waitress.manage(superLockerRobot);
        Ticket ticket = new Ticket(BagType.L);

        waitress.pickUp(ticket);

    }

    @Test
    public void should_reminder_incorrect_locker_type_when_manage_primary_robot_give_locker_s() throws IncorrectLockerTypeException {

        thrown.expect(IncorrectLockerTypeException.class);
        thrown.expectMessage(ExceptionMessages.INCORRECT_LOCKER_TYPE);

        Locker lockerS = new Locker(LockerType.S, 10);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot();
        primaryLockerRobot.manage(lockerS);
    }

    @Test
    public void should_reminder_incorrect_locker_type_when_manage_super_robot_give_locker_m() throws IncorrectLockerTypeException {

        thrown.expect(IncorrectLockerTypeException.class);
        thrown.expectMessage(ExceptionMessages.INCORRECT_LOCKER_TYPE);

        Locker lockerM = new Locker(LockerType.M, 10);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot();
        superLockerRobot.manage(lockerM);
    }


}
