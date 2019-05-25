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
    public void 손님은_자판기에서_음료를_구매할_수_있다() throws Exception {
        customer.buyBeverage("콜라", colaVendingMachine);
        boolean expectedResult = customer.hasBeverage("콜라");
        assertThat(expectedResult).isEqualTo(true);
    }

    @Test (expected = IllegalArgumentException.class)
    public void 자판기에_없는_음료는_구매할_수_없다() throws Exception {
        customer.buyBeverage("사이다", colaVendingMachine);
    }

    @Test
    public void 손님은_음료를_구매하면_잔액이_줄어든다() throws Exception {
        customer.buyBeverage("콜라", colaVendingMachine);
        int change = customer.getMoney();
        assertThat(change).isEqualTo(INITIAL_MONEY - 1_000);
    }
}