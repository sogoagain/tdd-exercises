import java.util.Objects;

public class Beverage {

    private final String name;
    private final int price;

    public static class Builder {
        private String name;
        private int price = 0;

        public Builder(String name) {
            this.name = name;
        }

        public Builder(Beverage beverage) {
            this.name = beverage.name;
            this.price = beverage.price;
        }

        public Builder price(int price) {
            this.price = price;
            return this;
        }

        public Beverage build() {
            return new Beverage(this);
        }
    }

    private Beverage(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beverage)) return false;
        Beverage beverage = (Beverage) o;
        return name.equals(beverage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
