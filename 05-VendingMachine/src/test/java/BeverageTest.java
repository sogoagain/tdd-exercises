import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BeverageTest {

    @Test
    public void 음료는_이름과_가격을_갖는다() throws Exception {
        final String COLA_NAME = "콜라";
        final int COLA_PRICE = 1_000;

        Beverage cola = new Beverage(COLA_NAME, COLA_PRICE);
        String beverageName = cola.getName();
        int beverageCost = cola.getPrice();

        assertThat(beverageName).isEqualTo(COLA_NAME);
        assertThat(beverageCost).isEqualTo(COLA_PRICE);
    }
}