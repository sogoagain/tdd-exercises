import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CustomerTest {

    private Customer customer;

    @Test
    public void test_CustomerTest() throws Exception {
        VendingMachine vavendingMachine = VendingMachine.createMachine();
        customer.putMoney(vendingMachine);
    }
}