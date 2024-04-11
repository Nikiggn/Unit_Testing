package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarShopTests {

    private  CarShop carShop;
    private Car car;

    @Before
    public void setUp(){
        carShop = new CarShop();
        car = new Car("Toyota", 120, 10000);
        carShop.add(car);
    }

    @Test
    public void test_Get_Cars(){
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        Assert.assertEquals(Collections.unmodifiableList(cars), carShop.getCars());
    }

    @Test
    public void test_Get_Max_HorsePower(){
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        Assert.assertEquals(cars, carShop.findAllCarsWithMaxHorsePower(1));
    }

    @Test(expected = NullPointerException.class)
    public void test_Car_Null(){
        carShop.add(null);
    }

    @Test
    public void test_Add_Correct(){
        carShop.add(new Car("Toyota", 100, 900));
        Assert.assertEquals(2, carShop.getCount());
    }

    @Test
    public void test_Remove_Correct(){
        carShop.remove(car);
        Assert.assertEquals(0, carShop.getCount());
    }

    @Test
    public void test_Most_Luxury(){
        Assert.assertEquals(car, carShop.getTheMostLuxuryCar());
    }

    @Test
    public void test_Find_By_Model(){
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        Assert.assertEquals(cars, carShop.findAllCarByModel("Toyota"));
    }

}

