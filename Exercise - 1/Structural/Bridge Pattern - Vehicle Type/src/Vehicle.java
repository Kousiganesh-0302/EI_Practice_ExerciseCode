public abstract class Vehicle {
    protected Engine engine;

    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    public abstract void manufacture();
}
