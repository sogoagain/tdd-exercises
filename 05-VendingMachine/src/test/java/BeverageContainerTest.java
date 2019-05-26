import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BeverageContainerTest {

    private final String COLA_NAME = "콜라";
    private final int AMOUNT_OF_COLA = 10;
    private final int COLA_PRICE = 1_000;

    private BeverageContainer beverageContainer = new BeverageContainer();

    @Test
    public void 음료컨테이너에는_음료를_추가할_수_있다() throws Exception {
        Beverage cola = new Beverage(COLA_NAME, COLA_PRICE);
        beverageContainer.add(cola, AMOUNT_OF_COLA);
        int amountOfColaInContainer = beverageContainer.getAmount(cola);

        assertThat(amountOfColaInContainer).isEqualTo(AMOUNT_OF_COLA);
    }

    @Test
    public void 음료컨테이너에_기존에_있던_음료를_추가하면_수량만_증가한다() throws Exception {
        Beverage cola1 = new Beverage(COLA_NAME, COLA_PRICE);
        beverageContainer.add(cola1, AMOUNT_OF_COLA);

        Beverage cola2 = new Beverage(COLA_NAME, COLA_PRICE);
        beverageContainer.add(cola2, AMOUNT_OF_COLA);

        int amountOfColaInContainer = beverageContainer.getAmount(cola1);

        assertThat(amountOfColaInContainer).isEqualTo(AMOUNT_OF_COLA * 2);
    }
}