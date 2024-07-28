public class DieselEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Diesel engine starting...");
    }

    @Override
    public void stop() {
        System.out.println("Diesel engine stopping...");
    }

    @Override
    public String getEngineType() {
        return "Diesel Engine";
    }
}
