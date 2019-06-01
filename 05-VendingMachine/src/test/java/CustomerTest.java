import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CustomerTest {

    private int INITIAL_MONEY = 10_000;
    private Customer customer;
    private VendingMachine colaVendingMachine;

    @Before
    public void initialize() {
        customer = new Customer(INITIAL_MONEY);
    }

    @Test
    public void 손님은_음료를_얻으면_돈이_차감된다() {
        
    }
}