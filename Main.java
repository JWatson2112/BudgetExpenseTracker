import java.util.Scanner;
import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Spending");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();//Consumes New Line

            switch (choice)
            {
                case 1:
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    tracker.addExpense(new Expense(category, amount, LocalDate.now(), desc));
                    break;
                case 2:
                    tracker.getExpenses().forEach(System.out::println);
                    break;
                case 3:
                    System.out.printf("Total Spending: $%.2f%n", tracker.getTotalSpending());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }

        }
    }
}
