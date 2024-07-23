import java.util.Scanner;

public class Main {
    private static double balance = 1000.00;  // Initial balance
    private static final int PIN = 1234;      // Default PIN

    public static void main(String[] args) {

        System.out.println("Welcome to ABC Bank");

        Scanner scanner = new Scanner(System.in);

        if (verifyPin(scanner)) {
            boolean quit = false;

            while (!quit) {
                System.out.println("\nMenu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Quit");
                System.out.print("\nChoose an option: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        depositMoney(scanner);
                        break;
                    case 3:
                        withdrawMoney(scanner);
                        break;
                    case 4:
                        quit = true;
                        System.out.println("\nThank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid PIN. Access denied.");
        }

        scanner.close();
    }

    private static boolean verifyPin(Scanner scanner) {
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();
        return enteredPin == PIN;
    }

    private static void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("You have successfully deposited $%.2f. Your new balance is $%.2f%n", amount, balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("You have successfully withdrawn $%.2f. Your new balance is $%.2f%n", amount, balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Please enter a lower amount.");
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }
}