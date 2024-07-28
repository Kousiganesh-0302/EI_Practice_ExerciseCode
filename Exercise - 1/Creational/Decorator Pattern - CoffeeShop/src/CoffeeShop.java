public class CoffeeShop {
    public Coffee addTopping(Coffee coffee, Topping topping) {
        return new ToppedCoffee(coffee, topping);
    }
}
