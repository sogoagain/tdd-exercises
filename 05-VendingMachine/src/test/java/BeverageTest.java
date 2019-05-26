import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BeverageTest {
    private final String COLA_NAME = "콜라";
    private final int COLA_PRICE = 1_000;

    @Test
    public void 음료는_이름과_가격을_갖는다() throws Exception {
        Beverage cola = new Beverage(COLA_NAME, COLA_PRICE);
        String beverageName = cola.getName();
        int beverageCost = cola.getPrice();

        assertThat(beverageName).isEqualTo(COLA_NAME);
        assertThat(beverageCost).isEqualTo(COLA_PRICE);
    }

    @Test
    public void 음료끼리_속성이_같으면_같은_음료다() {
        Beverage cola1 = new Beverage(COLA_NAME, COLA_PRICE);
        Beverage cola2 = new Beverage(COLA_NAME, COLA_PRICE);

        assertThat(cola1.equals(cola2)).isEqualTo(true);
    }

    @Test
    public void 음료의_속성이_하나라도_다르면_다른_음료다() {
        Beverage cheapCola = new Beverage(COLA_NAME, COLA_PRICE / 2);
        Beverage expensiveCola = new Beverage(COLA_NAME, COLA_PRICE);

        assertThat(cheapCola.equals(expensiveCola)).isEqualTo(false);
    }
}