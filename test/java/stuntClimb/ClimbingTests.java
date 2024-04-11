package stuntClimb;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClimbingTests {
    private Climbing climbing;

    @Before
    public void setUp(){
        climbing = new Climbing("Everest", 3);
        RockClimber rockClimber1 = new RockClimber("Peter", 250);
        RockClimber rockClimber2 = new RockClimber("Stefan", 350);
        RockClimber rockClimber3 = new RockClimber("Ivan", 500);

        climbing.addRockClimber(rockClimber1);
        climbing.addRockClimber(rockClimber2);
        climbing.addRockClimber(rockClimber3);
    }
    @Test(expected = NullPointerException.class)
    public  void test_Constructor_ShouldThrow_When_Name_Null(){
        climbing = new Climbing(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public  void test_Constructor_ShouldThrow_When_Name_Empty(){
        climbing = new Climbing("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public  void test_Constructor_ShouldThrow_When_Capacity_Negative(){
        climbing = new Climbing("Everest", -10);
    }

    @Test
    public  void test_Constructor_ShouldCreate_Correct_Object(){
        Assert.assertEquals("Everest",climbing.getName());
        Assert.assertEquals(3,climbing.getCapacity());

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_RockClimber_Should_Throw_When_LowCapacity(){
        climbing.addRockClimber(new RockClimber("Kalo", 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_RockClimber_Should_Throw_When_Climber_Duplicated(){
        climbing.addRockClimber(new RockClimber("Ivan", 100));
    }

    @Test
    public void test_Add_RockClimber_Should_Add_Correct_Climber(){
        Assert.assertEquals(3,climbing.getCount());
    }
    @Test
    public void test_RemoveRockClimber_Should_Remove_Success(){

        boolean isRemoved = climbing.removeRockClimber("Peter");
        Assert.assertTrue(isRemoved);
    }
    @Test
    public void test_RemoveRockClimber_Should_Remove_Not_Success(){
        boolean isRemoved = climbing.removeRockClimber("Pet");
        Assert.assertFalse(isRemoved);
    }


}
