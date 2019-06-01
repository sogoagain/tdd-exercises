import java.util.HashMap;
import java.util.Map;

public class BeverageContainer {

    private Map<Beverage, Integer> container = new HashMap<>();

    public void add(Beverage beverage, int amount) {
        int amountInContainer = container.getOrDefault(beverage, 0);
        container.put(beverage, amountInContainer + amount);
    }

    public boolean hasBeverage(Beverage beverage) {
        return container.containsKey(beverage);
    }

    public Beverage get(String beverageName) {
        Beverage beverage = new Beverage.Builder(beverageName).build();

        if (!hasBeverage(beverage)) {
            return null;
        }
        Beverage beverageInMap = container.keySet().stream().filter(beverage::equals).findAny().orElse(null);

        int amountInContainer = container.get(beverageInMap);
        container.put(beverageInMap, amountInContainer - 1);

        if (container.get(beverage) == 0) {
            container.remove(beverage);
        }

        assert beverageInMap != null;
        return new Beverage.Builder(beverageInMap).build();
    }
}
