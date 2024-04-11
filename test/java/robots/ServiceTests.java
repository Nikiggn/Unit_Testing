package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTests {
    private Service service;
    private Robot robot;

    @Before
    public void setUp(){
        service = new Service("Nik", 3);
        robot = new Robot("Al");
        Robot robot2 = new Robot("Er");
        Robot robot3 = new Robot("Kol");

        service.add(robot);
        service.add(robot2);
        service.add(robot3);
    }

    @Test(expected = NullPointerException.class)
    public void test_SetName_Should_Throw_When_Null(){
        service = new Service(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void test_SetName_Should_Throw_When_Empty(){
        service = new Service("", 3);
    }

//    @Test
//    public void test_valid_name(){
//
//    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetCapacity_Should_Throw_When_Below_Zero(){
        service = new Service("P", -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Should_Throw_When_NoCapacity(){
        service.add(new Robot("p"));
    }
    @Test
    public void test_Add_Correct(){
       Assert.assertEquals(3, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Remove_Should_Throw_When_Dont_Exist(){
        service.remove("f");
    }

    @Test
    public void test_Remove_Correct(){
        service.remove("Al");
        Assert.assertEquals(2, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ForSale_Should_Throw_When_DoesntExist(){
        service.forSale("h");
    }

    @Test
    public void testForSale(){
        service.forSale("Al");
        Assert.assertFalse(robot.isReadyForSale());
    }

    @Test
    public void testReport() {
        Assert.assertEquals("The robot Al, Er, Kol is in the service Nik!", service.report());
    }


}
