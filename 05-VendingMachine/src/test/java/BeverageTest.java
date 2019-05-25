import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BeverageTest {

    @Test
    public void 음료는_이름과_가격을_갖는다() throws Exception {
        final String COKE_NAME = "콜라";
        final int COKE_PRICE = 1_000;

        Beverage coke = new Beverage("COKE_NAME", COKE_PRICE);
        String beverageName = coke.getName();
        int beverageCost = coke.getPrice();

        assertThat(beverageName).isEqualTo(COKE_NAME);
        assertThat(beverageCost).isEqualTo(COKE_PRICE):
    }
}