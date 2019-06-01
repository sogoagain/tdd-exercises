import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

/*
자판기 요구사항
1. 입금 가능
3. 상품 구매 가능
*/

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Before
    public void init() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void 자판기는_돈을_입금_받는다() {
        final int INPUT_MONEY = 2_000;
        int totalMoney = vendingMachine.putMoney(INPUT_MONEY);
        assertThat(totalMoney).isEqualTo(INPUT_MONEY);
    }

    @Test
    public void 자판기는_음료수를_판매한다() {
        final int INPUT_MONEY = 2_000;

    }

}