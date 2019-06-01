public class VendingMachine {

    private BeverageContainer container = new BeverageContainer();

    public void addBeverages(String beverageName, int beveragePrice, int amount) {
        Beverage beverage = new Beverage
                .Builder(beverageName)
                .price(beveragePrice)
                .build();

        container.add(beverage, amount);
    }

    public boolean hasBeverage(String beverageName) {
        Beverage beverage = new Beverage.Builder(beverageName).build();
        return container.hasBeverage(beverage);
    }

    public Beverage pullBeverage(String beverageName) {
        Beverage beverage = new Beverage.Builder(beverageName).build();
        if (!container.hasBeverage(beverage)) {
            throw new IllegalArgumentException("자판기에 음료가 없습니다.");
        }

        beverage = container.get(beverage);
        container.decrease(beverage);
        return beverage;
    }
}
