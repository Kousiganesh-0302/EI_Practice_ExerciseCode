public class ToppedCoffee implements Coffee {
    private Coffee coffee;
    private Topping topping;

    public ToppedCoffee(Coffee coffee, Topping topping) {
        this.coffee = coffee;
        this.topping = topping;
    }

    @Override
    public double cost() {
        return coffee.cost() + topping.cost();
    }

    @Override
    public String description() {
        return coffee.description() + ", " + topping.description();
    }
}
