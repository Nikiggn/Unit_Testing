package handball;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeamTests {

   private Team team;

   @Before
    public void setUp(){
       team = new Team("Real", 3);

       HandballPlayer handballPlayer1 = new HandballPlayer("Pesho");
       HandballPlayer handballPlayer2 = new HandballPlayer("Aleks");
       HandballPlayer handballPlayer3 = new HandballPlayer("Misho");

       team.add(handballPlayer1);
       team.add(handballPlayer2);
       team.add(handballPlayer3);
   }

   @Test(expected = NullPointerException.class)
   public void test_Should_Throw_When_Name_Null(){
      team = new Team(null, 3);
   }

   @Test(expected = NullPointerException.class)
   public void test_Should_Throw_When_Name_Blank(){
      team = new Team("", 3);
   }

   @Test(expected = IllegalArgumentException.class)
   public void test_Should_Throw_When_Position_Below_Zero(){
      team = new Team("Ali", -1);
   }

   @Test
   public void test_Constructor_ShouldCreate_Correct_Object(){
      Assert.assertEquals("Real",team.getName());
      Assert.assertEquals(3,team.getPosition());
   }

   @Test(expected = IllegalArgumentException.class)
   public void test_add_player_shouldThrow(){
      team.add(new HandballPlayer("pes"));
   }

   @Test
   public void test_add_player_correct(){
      Assert.assertEquals(3, team.getCount());
   }

   @Test
   public void test_Team_Should_Remove_Success(){
      team.remove("Pesho");
      Assert.assertEquals(2,team.getCount());
   }
   @Test(expected = IllegalArgumentException.class)
   public void test_RemoveRockClimber_Should_Remove_Not_Success(){
      team.remove("p");
   }

   @Test(expected = IllegalArgumentException.class)
   public void ecv(){
      team.remove("f");
   }
}
