package archeologicalExcavations;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {

    private Excavation excavation;
    private Archaeologist archaeologist;

    @Before
    public void setUp(){
        excavation = new Excavation("Elprom", 2);
        archaeologist = new Archaeologist("Nik", 5);
        excavation.addArchaeologist(archaeologist);
    }

    @Test(expected = NullPointerException.class)
    public void test_Name_Null(){
        excavation = new Excavation(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void test_Name_Empty(){
        excavation = new Excavation("", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Capacity_Negative(){
        excavation = new Excavation("Nikola", -1);
    }

    @Test
    public void test_Correct_Object(){
        Assert.assertEquals("Elprom", excavation.getName());
        Assert.assertEquals(2, excavation.getCapacity());
    }

    @Test
    public void test_Add_Correct(){
        excavation.addArchaeologist(new Archaeologist("Pesho", 5));
        Assert.assertEquals(2, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Full_Capacity(){
        excavation.addArchaeologist(new Archaeologist("Pesho1", 5));
        excavation.addArchaeologist(new Archaeologist("Pesho2", 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Existing(){
        excavation.addArchaeologist(new Archaeologist("Nik", 1));
    }

    @Test
    public void test_Remove_Correct(){
        excavation.removeArchaeologist("Nik");
        Assert.assertEquals(0, excavation.getCount());
    }

    @Test
    public void test_Remove_True(){
        Assert.assertTrue(excavation.removeArchaeologist("Nik"));
    }

    @Test
    public void test_Remove_False(){
        Assert.assertFalse(excavation.removeArchaeologist("Nik123"));
    }
}
