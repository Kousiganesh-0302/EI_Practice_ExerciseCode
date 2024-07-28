import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        RemoteControl remote = new RemoteControl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a command (type 'exit' to quit):");
            System.out.println("1. Turn on TV");
            System.out.println("2. Turn off TV");
            System.out.println("3. Change channel");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                break;
            }

            switch (choice) {
                case "1":
                    remote.setCommand(new TurnOnCommand(tv));
                    remote.pressButton();
                    break;
                case "2":
                    remote.setCommand(new TurnOffCommand(tv));
                    remote.pressButton();
                    break;
                case "3":
                    System.out.println("Enter channel number:");
                    int channel = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    remote.setCommand(new ChangeChannelCommand(tv, channel));
                    remote.pressButton();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }

        scanner.close();
    }
}
