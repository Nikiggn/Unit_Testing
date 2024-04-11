package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BankTests {
    private Bank bank;
    private Client client;

    @Before
    public void setUp(){
        bank = new Bank("OBB", 2);

        client = new Client("Gosho");
        bank.addClient(client);
    }

    @Test(expected = NullPointerException.class)
    public void test_Name_Null(){
        bank = new Bank(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void test_Name_Empty(){
        bank = new Bank("", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Capacity_Negative(){
        bank = new Bank("Nikola", -1);
    }

    @Test
    public void test_Correct_Object(){
        Assert.assertEquals("OBB", bank.getName());
        Assert.assertEquals(2, bank.getCapacity());
    }

   @Test(expected = IllegalArgumentException.class)
    public void test_Full_Capacity(){
        bank.addClient(new Client("P"));
       bank.addClient(new Client("P"));
   }

    @Test(expected = IllegalArgumentException.class)
    public void test_Remove(){
        bank.removeClient("Pitur");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Loan(){
        bank.loanWithdrawal("Pitur");
    }

    @Test
    public void test_Stats(){
        Assert.assertEquals("The client Gosho is at the OBB bank!", bank.statistics());
    }

    @Test
    public void testLoanWithdrawal() {
        bank.loanWithdrawal("Gosho");
        Assert.assertFalse(client.isApprovedForLoan());
    }
}
