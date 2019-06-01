import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Before
    public void init() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void 자판기에_음료수를_넣는다() {
        vendingMachine.addBeverages("콜라", 1_000, 100);
        boolean hasBeverage = vendingMachine.hasBeverage("콜라");

        assertThat(hasBeverage).isTrue();
    }

    @Test
    public void 자판기에서_음료수를_뽑는다() {
        vendingMachine.addBeverages("콜라", 1_000, 1);
        Beverage beverage = vendingMachine.pullBeverage("콜라");

        assertThat(beverage).isInstanceOf(Beverage.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 자판기에_뽑을_음료수가_부족하면_예외를_던진다() {
        Beverage beverage = vendingMachine.pullBeverage("콜라");
    }
}