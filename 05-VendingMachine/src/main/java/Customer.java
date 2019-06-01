public class Customer {

    private int money;
    private BeverageContainer container = new BeverageContainer();

    public Customer(int money) {
        this.money = money;
    }

    public boolean buy(Beverage beverage) {
        if (money < beverage.getPrice()) {
            return false;
        }

        container.add(beverage, 1);
        money -= beverage.getPrice();
        return true;
    }
}
