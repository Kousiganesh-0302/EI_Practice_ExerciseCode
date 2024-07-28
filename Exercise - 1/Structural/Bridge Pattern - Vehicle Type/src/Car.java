public class Car extends Vehicle {
    public Car(Engine engine) {
        super(engine);
    }

    @Override
    public void manufacture() {
        System.out.println("Manufacturing car with " + engine.getEngineType());
        engine.start();
        engine.stop();
    }
}
