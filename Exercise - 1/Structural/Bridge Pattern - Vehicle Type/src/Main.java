import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter vehicle type (car, truck, motorcycle) or type 'exit' to quit:");
            String vehicleType = scanner.nextLine();
            if (vehicleType.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter engine type (gasoline, diesel, electric):");
            String engineType = scanner.nextLine();

            Engine engine = null;
            switch (engineType.toLowerCase()) {
                case "gasoline":
                    engine = new GasolineEngine();
                    break;
                case "diesel":
                    engine = new DieselEngine();
                    break;
                case "electric":
                    engine = new ElectricEngine();
                    break;
                default:
                    System.out.println("Invalid engine type. Please try again.");
                    continue;
            }

            Vehicle vehicle = null;
            switch (vehicleType.toLowerCase()) {
                case "car":
                    vehicle = new Car(engine);
                    break;
                case "truck":
                    vehicle = new Truck(engine);
                    break;
                case "motorcycle":
                    vehicle = new Motorcycle(engine);
                    break;
                default:
                    System.out.println("Invalid vehicle type. Please try again.");
                    continue;
            }

            vehicle.manufacture();
        }

        scanner.close();
    }
}
