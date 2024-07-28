public class Truck extends Vehicle {
    public Truck(Engine engine) {
        super(engine);
    }

    @Override
    public void manufacture() {
        System.out.println("Manufacturing truck with " + engine.getEngineType());
        engine.start();
        engine.stop();
    }
}
