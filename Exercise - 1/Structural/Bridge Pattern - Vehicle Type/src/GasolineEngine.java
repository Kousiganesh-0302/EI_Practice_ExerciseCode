public class GasolineEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Gasoline engine starting...");
    }

    @Override
    public void stop() {
        System.out.println("Gasoline engine stopping...");
    }

    @Override
    public String getEngineType() {
        return "Gasoline Engine";
    }
}
