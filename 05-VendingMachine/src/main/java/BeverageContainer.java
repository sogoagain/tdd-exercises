import java.util.HashMap;
import java.util.Map;

public class BeverageContainer {

    private Map<Beverage, Integer> container = new HashMap<>();

    public void add(Beverage beverage, int amount) {
        container.computeIfPresent(beverage, (k, v) -> v += amount);
        container.putIfAbsent(beverage, amount);
    }

    public int getAmount(Beverage beverage) {
        if (!container.containsKey(beverage)) {
            return 0;
        }
        return container.get(beverage);
    }
}
