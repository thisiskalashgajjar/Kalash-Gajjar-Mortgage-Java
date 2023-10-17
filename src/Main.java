import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the current interest rate from the user
        System.out.print("Enter the current interest rate (as a decimal, e.g., 0.04 for 4%): ");
        double currentInterestRate = scanner.nextDouble();

        Mortgage[] mortgages = new Mortgage[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("\nSelect mortgage type:");
            System.out.println("1. Business Mortgage");
            System.out.println("2. Personal Mortgage");
            System.out.print("Enter your choice (1 or 2): ");
            int mortgageType = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter mortgage amount: $");
            double mortgageAmount = scanner.nextDouble();

            System.out.print("Enter mortgage term (1 for short-term, 3 for medium-term, 5 for long-term): ");
            int term = scanner.nextInt();

            if (mortgageType == 1) {
                mortgages[i] = new BusinessMortgage(i + 1, customerName, mortgageAmount, term);
            } else if (mortgageType == 2) {
                mortgages[i] = new PersonalMortgage(i + 1, customerName, mortgageAmount, term);
            }
        }

        scanner.close();

        // Display all mortgages
        System.out.println("\nAll Mortgages:");
        for (Mortgage mortgage : mortgages) {
            System.out.println(mortgage.getMortgageInfo());
            System.out.printf("Monthly Payment: $%.2f\n\n", mortgage.calculateMonthlyPayment());
        }
    }
}