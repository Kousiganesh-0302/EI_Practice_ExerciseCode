public class CreamTopping implements Topping {
    @Override
    public double cost() {
        return 0.5;
    }

    @Override
    public String description() {
        return "Cream";
    }
}
