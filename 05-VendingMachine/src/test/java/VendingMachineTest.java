import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Before
    public void initialize() {
        BeverageContainer beverageContainer = new BeverageContainer();
        List<Beverage> beverages = makeBeverageDummy();

        for (Beverage beverage :
                beverages) {
            beverageContainer.add(beverage, 10);
        }

        vendingMachine = new VendingMachine(beverageContainer);
    }

    @Test
    public void 자판기는_음료를_

    private List<Beverage> makeBeverageDummy() {
        Map<String, Integer> beverageInfos = Map.of("콜라", 1_000, "사이다", 900, "환타", 700, "물", 500);
        List<Beverage> beverages = new ArrayList<>();

        for (Map.Entry<String, Integer> entry:
                beverageInfos.entrySet()) {
            String beverageName = entry.getKey();
            int beveragePrice = entry.getValue();
            Beverage beverage = new Beverage(beverageName, beveragePrice);

            beverages.add(beverage);
        }

        return beverages;
    }

}