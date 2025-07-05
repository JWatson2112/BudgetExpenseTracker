import java.util.*;
import java.io.*;
import java.time.LocalDate;
public class ExpenseTracker
{
    private List<Expense> expenses;
    private static final String FILE_PATH = "expenses.csv";

    public ExpenseTracker()
    {
        this.expenses = new ArrayList<>();
        loadExpenses();
    }

    // Add a new expense
    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpenses(); // Auto-save after adding
    }
    public double getTotalSpending() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public List<Expense> getExpenses()
    {
        return Collections.unmodifiableList(expenses); // Prevents external edits
    }

    // Save to CSV file (simple format)
    private void saveExpenses() {
        try (PrintWriter writer = new PrintWriter(FILE_PATH)) {
            for (Expense e : expenses) {
                writer.println(String.format("%s,%.2f,%s,%s",
                        e.getCategory(), e.getAmount(), e.getDate(), e.getDescription()));
            }
        } catch (IOException e) {
            System.err.println("Error saving expenses: " + e.getMessage());
        }
    }

    // Load from CSV
    private void loadExpenses() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                Expense expense = new Expense(
                        parts[0],
                        Double.parseDouble(parts[1]),
                        LocalDate.parse(parts[2]),
                        parts[3]
                );
                expenses.add(expense);
            }
        } catch (IOException e) {
            System.err.println("Error loading expenses: " + e.getMessage());
        }
    }
}
