import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter payment amount (type 'exit' to quit): ");
            String amountInput = scanner.nextLine();
            if (amountInput.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                int amount = Integer.parseInt(amountInput);

                System.out.println("Choose payment method:");
                System.out.println("1. Credit Card");
                System.out.println("2. PayPal");

                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("Enter card number: ");
                        String cardNumber = scanner.nextLine();
                        System.out.println("Enter card holder name: ");
                        String cardHolderName = scanner.nextLine();
                        paymentProcessor.setPaymentStrategy(new CreditCardPayment(cardNumber, cardHolderName));
                        break;
                    case "2":
                        System.out.println("Enter PayPal email: ");
                        String emailId = scanner.nextLine();
                        System.out.println("Enter PayPal password: ");
                        String password = scanner.nextLine();
                        paymentProcessor.setPaymentStrategy(new PayPalPayment(emailId, password));
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                        continue;
                }

                paymentProcessor.processPayment(amount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numerical value.");
            }
        }

        scanner.close();
    }
}
