package scubaDive;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivingTests {

    private Diving diving;

    @Before
    public void setUp(){
        diving = new Diving("Nikola", 3);

        diving.addDeepWaterDiver(new DeepWaterDiver("Aleks", 5));
        diving.addDeepWaterDiver(new DeepWaterDiver("Misho", 6));
       // diving.addDeepWaterDiver(new DeepWaterDiver("Maksi", 7));
    }


    @Test(expected = NullPointerException.class)
    public void test_Name_Null(){
        diving = new Diving(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void test_Name_Empty(){
        diving = new Diving("", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Capacity_Negative(){
        diving = new Diving("Nikola", -1);
    }

    @Test
    public void test_Correct_Object(){
        Assert.assertEquals("Nikola", diving.getName());
        Assert.assertEquals(3, diving.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_NoCapacity(){
        diving.addDeepWaterDiver(new DeepWaterDiver("Pesho", 10));
        diving.addDeepWaterDiver(new DeepWaterDiver("Pesho2", 10));
    }

//    @Test (expected = IllegalArgumentException.class)
//    public void testAddDeepWaterDiverExist() throws IllegalArgumentException {
//        diving.addDeepWaterDiver(diver);
//    }

    @Test
    public void test_Add_Correct(){
       diving.addDeepWaterDiver(new DeepWaterDiver("Pesho", 10));
       Assert.assertEquals(3, diving.getCount());
    }

    @Test
    public void test_Remove_Correct(){
        diving.removeDeepWaterDiver("Misho");
        Assert.assertEquals(1, diving.getCount());
    }

    @Test
    public void test_Remove_True(){
        boolean tu = diving.removeDeepWaterDiver("Misho");
        Assert.assertTrue(tu);
    }

    @Test
    public void test_Remove_False(){
        boolean tu = diving.removeDeepWaterDiver("M");
        Assert.assertFalse(tu);
    }





}
