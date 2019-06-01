import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BeverageContainerTest {

    private final String COLA_NAME = "콜라";
    private final int COLA_PRICE = 1_000;

    private BeverageContainer beverageContainer = new BeverageContainer();

    @Test
    public void 음료컨테이너에는_음료를_추가할_수_있다() {
        Beverage cola = new Beverage
                .Builder(COLA_NAME)
                .price(COLA_PRICE)
                .build();
        int amountOfCola = 10;
        beverageContainer.add(cola, amountOfCola);

        boolean hasBeverageInContainer = beverageContainer.hasBeverage(cola);
        assertThat(hasBeverageInContainer).isTrue();
    }

    @Test
    public void 음료컨테이너에_없는_음료_확인() {
        Beverage cola = new Beverage
                .Builder(COLA_NAME)
                .build();

        boolean hasBeverageInContainer = beverageContainer.hasBeverage(cola);
        assertThat(hasBeverageInContainer).isFalse();
    }

    @Test
    public void 음료컨테이너에서_음료를_꺼낸다() {
        Beverage cola = new Beverage
                .Builder(COLA_NAME)
                .price(COLA_PRICE)
                .build();
        beverageContainer.add(cola, 1);
        Beverage colaByContainer = beverageContainer.get(COLA_NAME);

        assertThat(colaByContainer).isEqualTo(cola);

    }

    @Test
    public void 뽑을_음료의_수량이_부족하면_null이_나온다() {
        Beverage cola1 = new Beverage
                .Builder(COLA_NAME)
                .price(COLA_PRICE)
                .build();
        beverageContainer.add(cola1, 1);

        Beverage cola2 = new Beverage
                .Builder(COLA_NAME)
                .price(COLA_PRICE)
                .build();
        beverageContainer.add(cola2, 1);

        beverageContainer.get(COLA_NAME);
        beverageContainer.get(COLA_NAME);
        Beverage colaByContainer = beverageContainer.get(COLA_NAME);

        assertThat(colaByContainer).isNull();
    }
}