import java.util.Scanner;
import java.util.logging.Logger;

public class RocketLaunchSimulator {
    private static final Logger logger = Logger.getLogger(RocketLaunchSimulator.class.getName());
    private static final int MAX_FUEL = 100;
    private static final int MAX_ALTITUDE = 200;
    private static final int MAX_SPEED = 10000;
    private static final int STAGE_1_FUEL_CONSUMPTION = 10;
    private static final int STAGE_2_FUEL_CONSUMPTION = 5;
    private static final int STAGE_1_ALTITUDE_GAIN = 10;
    private static final int STAGE_2_ALTITUDE_GAIN = 20;
    private static final int STAGE_1_SPEED_GAIN = 1000;
    private static final int STAGE_2_SPEED_GAIN = 2000;

    private int fuel;
    private int altitude;
    private int speed;
    private int stage;
    private boolean missionFailed;

    public RocketLaunchSimulator() {
        resetSimulation();
    }

    public void startSimulation() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (start_checks, launch, fast_forward, abort):");
            String command = scanner.nextLine();
            switch (command) {
                case "start_checks":
                    startChecks();
                    break;
                case "launch":
                    launch();
                    break;
                case "fast_forward":
                    fastForward(scanner);
                    break;
                case "abort":
                    abortMission();
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
            if (missionFailed) {
                break;
            }
        }
        scanner.close();
    }

    private void startChecks() {
        System.out.println("Starting pre-launch checks...");
        pauseSimulation(2000);
        resetSimulation();
        System.out.println("All systems are 'Go' for launch.");
    }

    private void launch() {
        if (missionFailed) {
            System.out.println("Mission Failed previously. Please restart simulation.");
            return;
        }
        System.out.println("Launching rocket...");
        while (fuel > 0 && altitude < MAX_ALTITUDE && speed < MAX_SPEED) {
            updateRocketState();
            displayRocketState();
            if (fuel <= 0) {
                missionFailed = true;
                System.out.println("Mission Failed due to insufficient fuel.");
                return;
            } else if (altitude >= MAX_ALTITUDE && speed >= MAX_SPEED) {
                System.out.println("Orbit achieved! Mission Successful.");
                return;
            }
            if (stage == 1 && fuel <= 50) {
                switchStage();
            }
            pauseSimulation(1000);
        }
    }

    private void fastForward(Scanner scanner) {
        if (missionFailed) {
            System.out.println("Mission Failed previously. Please restart simulation.");
            return;
        }
        System.out.println("Enter number of seconds to fast forward:");
        int seconds = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < seconds; i++) {
            if (fuel <= 0 || altitude >= MAX_ALTITUDE && speed >= MAX_SPEED) {
                break;
            }
            updateRocketState();
            displayRocketState();
            if (fuel <= 0) {
                missionFailed = true;
                System.out.println("Mission Failed due to insufficient fuel.");
                break;
            } else if (altitude >= MAX_ALTITUDE && speed >= MAX_SPEED) {
                System.out.println("Orbit achieved! Mission Successful.");
                break;
            }
            if (stage == 1 && fuel <= 50) {
                switchStage();
            }
            pauseSimulation(1000);
        }
    }

    private void abortMission() {
        System.out.println("Mission aborted by user. Returning to launch pad.");
        missionFailed = true;
    }

    private void updateRocketState() {
        if (stage == 1) {
            fuel -= STAGE_1_FUEL_CONSUMPTION;
            altitude += STAGE_1_ALTITUDE_GAIN;
            speed += STAGE_1_SPEED_GAIN;
        } else if (stage == 2) {
            fuel -= STAGE_2_FUEL_CONSUMPTION;
            altitude += STAGE_2_ALTITUDE_GAIN;
            speed += STAGE_2_SPEED_GAIN;
        }
    }

    private void displayRocketState() {
        System.out.println("Stage: " + stage + ", Fuel: " + fuel + "%, Altitude: " + altitude + " km, Speed: " + speed + " km/h");
    }

    private void switchStage() {
        stage = 2;
        System.out.println("Stage 1 complete. Separating stage. Entering Stage 2.");
    }

    private void resetSimulation() {
        this.fuel = MAX_FUEL;
        this.altitude = 0;
        this.speed = 0;
        this.stage = 1;
        this.missionFailed = false;
    }

    private void pauseSimulation(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            logger.severe("Error during simulation pause: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        RocketLaunchSimulator simulator = new RocketLaunchSimulator();
        simulator.startSimulation();
    }
}
