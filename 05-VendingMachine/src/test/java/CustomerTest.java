import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CustomerTest {

    private final String COLA_NAME = "콜라";
    private final int COLA_PRICE = 1_000;

    private Customer customer;

    @Before
    public void initialize() {
        int initialMoney = 10_000;
        customer = new Customer(initialMoney);
    }

    @Test
    public void 손님은_음료를_살_수_있다() {
        Beverage cola = new Beverage
                .Builder(COLA_NAME)
                .price(COLA_PRICE)
                .build();

        boolean canBuyCola = customer.buy(cola);

        assertThat(canBuyCola).isTrue();
    }

    @Test
    public void 손님은_자신이_갖고있는_돈_보다_비싼_음료를_못산다() {
        Beverage expensiveBeverage = new Beverage
                .Builder("비싼음료")
                .price(20_000)
                .build();

        boolean canBuyExpensiveBeverage = customer.buy(expensiveBeverage);

        assertThat(canBuyExpensiveBeverage).isFalse();
    }

    @Test
    public void 손님은_음료를_구매하면_돈이_차감된다() {
        Beverage expensiveBeverage = new Beverage
                .Builder("비싼음료")
                .price(10_000)
                .build();

        Beverage cola = new Beverage
                .Builder(COLA_NAME)
                .price(COLA_PRICE)
                .build();

        customer.buy(expensiveBeverage);
        boolean canBuyColaWhenNoMoney = customer.buy(cola);

        assertThat(canBuyColaWhenNoMoney).isFalse();

    }
}