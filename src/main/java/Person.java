import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {

    private String name;
    private List<Double> expenses;
    private Map<String, Double> extraExpenses;
    private double refund = 0;

    public Person(String name) {
        this.name = name;
        this.expenses = new ArrayList<>();
        this.extraExpenses = new HashMap<>();
    }

    public void addExpense(double expense) {
        expenses.add(expense);
    }

    public void setExpenses(List<Double> expenses)
    {
        this.expenses = expenses;
    }

    public void removeLastExpense() {
        expenses.remove(expenses.size() - 1);
    }

    public String getName() {
        return name;
    }

    public List<Double> getExpenses() {
        return expenses;
    }

    public double getRefund() {
        return refund;
    }

    public void setRefund(double refund) {
        this.refund = refund;
    }

    public Map<String, Double> getExtraExpenses() {
        return extraExpenses;
    }

    @Override
    public String toString() {
        return name;
    }
}
