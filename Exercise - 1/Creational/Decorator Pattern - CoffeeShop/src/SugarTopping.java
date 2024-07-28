public class SugarTopping implements Topping {
    @Override
    public double cost() {
        return 0.25;
    }

    @Override
    public String description() {
        return "Sugar";
    }
}
