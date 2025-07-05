import java.time.LocalDate;
//better than strings or raw numbers

public class Expense
{
    private String category;
    private double amount;
    private LocalDate date;
    private String description;


    //Constructor Class
    public Expense(String category, double amount, LocalDate date, String description)
    {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    //Getters - made without setters to keep immutability (modification after creation)
    public String getCategory() {return  category;}
    public double getAmount() {return amount;}
    public LocalDate getDate(){return date;}
    public String getDescription(){return description;}

    @Override
    public String toString()
    {
        return String.format("[%s] $%.2f (%s) - %s",
                category, amount, date, description);
    }
}
