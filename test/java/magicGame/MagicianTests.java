package magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MagicianTests {

    private Magician magician;
    private Magic magic;

    @Before
    public void setUp(){
        magician = new Magician("Nik", 5);
        magic = new Magic("Laika", 3);
        magician.addMagic(magic);
    }

    @Test(expected = NullPointerException.class)
    public void test_Name_Null(){
        magician = new Magician(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void test_Name_Empty(){
        magician = new Magician("", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Health_Negative(){
        magician = new Magician("Nikola", -1);
    }

    @Test
    public void test_Correct_Object(){
        Assert.assertEquals("Nik", magician.getUsername());
        Assert.assertEquals(5, magician.getHealth());
    }

    @Test
    public void test_Get_Magics(){
        List<Magic> magics = new ArrayList<>();
        magics.add(magic);
        Assert.assertEquals(Collections.unmodifiableList(magics), magician.getMagics());
    }

    @Test(expected = IllegalStateException.class)
    public void test_Take_Damage_When_Dead(){
        magician.takeDamage(5);
        magician.takeDamage(2);
    }

    @Test
    public void test_Take_Damage_Equals_Under_Zero(){
        magician.takeDamage(6);
        Assert.assertEquals(0, magician.getHealth());
    }
    @Test
    public void test_Take_Damage(){
        magician.takeDamage(1);
        Assert.assertEquals(4, magician.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void test_Add_Null(){
        magician.addMagic(null);
    }

    @Test
    public void test_Add_Correct(){
        magician.addMagic(new Magic("Milinka", 5));
        Assert.assertEquals(2, magician.getMagics().size());
    }

    @Test
    public void test_Remove_Correct(){
        magician.removeMagic(magic);
        Assert.assertEquals(0, magician.getMagics().size());
    }

    @Test
    public void test_Get_Magic(){
        Assert.assertEquals(magic, magician.getMagic("Laika"));
    }
}
