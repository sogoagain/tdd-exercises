import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BeverageTest {
    private final String COLA_NAME = "콜라";
    private final int COLA_PRICE = 1_000;

    @Test
    public void 음료는_이름과_가격을_갖는다() {
        Beverage cola = new Beverage
                .Builder(COLA_NAME)
                .price(COLA_PRICE)
                .build();

        assertThat(cola).isInstanceOf(Beverage.class);
    }

    @Test
    public void 음료는_이름만으로_생성할_수_있다() {
        Beverage cola = new Beverage
                .Builder(COLA_NAME)
                .build();

        assertThat(cola).isInstanceOf(Beverage.class);
    }

    @Test
    public void 음료끼리_이름이_같으면_같은_음료다() {
        Beverage cola1 = new Beverage
                .Builder(COLA_NAME)
                .price(COLA_PRICE)
                .build();

        Beverage cola2 = new Beverage
                .Builder(COLA_NAME)
                .build();

        assertThat(cola1.equals(cola2)).isTrue();
    }

    @Test
    public void 음료객체로_새로운_음료객체를_만들_수_있다() {
        Beverage cola1 = new Beverage
                .Builder(COLA_NAME)
                .price(COLA_PRICE)
                .build();

        Beverage cola2 = new Beverage
                .Builder(cola1)
                .build();

        assertThat(cola1.equals(cola2)).isTrue();
    }
}