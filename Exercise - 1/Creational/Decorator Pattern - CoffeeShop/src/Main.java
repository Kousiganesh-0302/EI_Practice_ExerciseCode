import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Coffee coffee = new SimpleCoffee();
        CoffeeShop coffeeShop = new CoffeeShop();

        while (true) {
            System.out.println("Current coffee: " + coffee.description() + " | Cost: " + coffee.cost());
            System.out.println("Choose a topping to add (type 'done' to finish):");
            System.out.println("1. Cream");
            System.out.println("2. Sugar");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("done")) {
                break;
            }

            switch (choice) {
                case "1":
                    coffee = coffeeShop.addTopping(coffee, new CreamTopping());
                    break;
                case "2":
                    coffee = coffeeShop.addTopping(coffee, new SugarTopping());
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }

        System.out.println("Final coffee: " + coffee.description());
        System.out.println("Total cost: " + coffee.cost());
        scanner.close();
    }
}
