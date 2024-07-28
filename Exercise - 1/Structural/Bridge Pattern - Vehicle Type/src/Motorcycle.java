public class Motorcycle extends Vehicle {
    public Motorcycle(Engine engine) {
        super(engine);
    }

    @Override
    public void manufacture() {
        System.out.println("Manufacturing motorcycle with " + engine.getEngineType());
        engine.start();
        engine.stop();
    }
}
