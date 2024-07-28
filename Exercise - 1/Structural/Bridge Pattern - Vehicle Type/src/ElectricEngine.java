public class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric engine starting...");
    }

    @Override
    public void stop() {
        System.out.println("Electric engine stopping...");
    }

    @Override
    public String getEngineType() {
        return "Electric Engine";
    }
}
