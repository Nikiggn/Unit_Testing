package football;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
    private FootballTeam footballTeam;
    private Footballer footballer;


    @Before
    public void setUp(){
        footballTeam = new FootballTeam("Ticha", 2);
        footballer = new Footballer("Nik");
        footballTeam.addFootballer(footballer);
    }

    @Test(expected = NullPointerException.class)
    public void test_Name_Null(){
        footballTeam = new FootballTeam(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void test_Name_Empty(){
        footballTeam = new FootballTeam("", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Capacity_Negative(){
        footballTeam = new FootballTeam("Nikola", -1);
    }

    @Test
    public void test_Correct_Object(){
            Assert.assertEquals("Ticha", footballTeam.getName());
        Assert.assertEquals(2, footballTeam.getVacantPositions());
    }

    @Test
    public void test_Add_Correct(){
        footballTeam.addFootballer(new Footballer("P"));
        Assert.assertEquals(2, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Full_Capacity(){
        footballTeam.addFootballer(new Footballer("P"));
        footballTeam.addFootballer(new Footballer("T"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Remove_Non_Existing(){
        footballTeam.removeFootballer("Pesho");
    }

    @Test
    public void test_Remove_Correct(){
        footballTeam.removeFootballer("Nik");
        Assert.assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_For_Sale_Non_Existing(){
        footballTeam.footballerForSale("Pesho");
    }

    @Test
    public void test_For_Sale_Correct(){
        footballTeam.footballerForSale("Nik");
        Assert.assertFalse(footballer.isActive());
    }

    @Test
    public void test_Stats(){
        Assert.assertEquals("The footballer Nik is in the team Ticha.", footballTeam.getStatistics());
    }

}
