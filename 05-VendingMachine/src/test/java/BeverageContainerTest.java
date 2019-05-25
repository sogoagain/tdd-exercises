import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BeverageContainerTest {

    private BeverageContainer beverageContainer = new BeverageContainer();

    @Test
    public void 음료컨테이너에는_음료를_추가할_수_있다() throws Exception {
        final String COLA_NAME = "콜라";
        final int AMOUNT_OF_COLA = 10;
        final int COLA_PRICE = 1_000;

        Beverage cola = new Beverage(COLA_NAME, COLA_PRICE);
        beverageContainer.add(cola, AMOUNT_OF_COLA);
        int amountOfColaInContainer = beverageContainer.getAmount(cola);

        assertThat(amountOfColaInContainer).isEqualTo(AMOUNT_OF_COLA);
    }
}