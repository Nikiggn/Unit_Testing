package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PetStoreTests {

    private PetStore petStore;
    private Animal animal;

    @Before
    public void setUp(){
        petStore = new PetStore();
        animal = new Animal("Kote", 5, 10);
        petStore.addAnimal(animal);
    }

    @Test
    public void test_Get_Animals(){
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        Assert.assertEquals(Collections.unmodifiableList(animals), petStore.getAnimals());
    }

    @Test
    public void test_Get_Count(){
        Assert.assertEquals(1, petStore.getCount());
    }

    @Test
    public void test_Find_Max_Kilo(){
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        Assert.assertEquals(animals, petStore.findAllAnimalsWithMaxKilograms(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Null(){
        petStore.addAnimal(null);
    }

    @Test
    public void test_Add_Correct(){
        petStore.addAnimal(new Animal("Kuche", 5, 10));
        Assert.assertEquals(2, petStore.getCount());
    }

    @Test
    public void test_Find_Most_Exp(){
        petStore.addAnimal(new Animal("Kuche", 5, 9));
        Assert.assertEquals(animal, petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void test_Find_By_Species(){
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        Assert.assertEquals(animals, petStore.findAllAnimalBySpecie("Kote"));
    }

}

