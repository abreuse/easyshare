import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorUT {

    private Person person;
    private Calculator calculator;

    @Before
    public void before() {
        person = new Person("test");
        person.addExpense(2);
        person.addExpense(3);
        person.addExpense(4);

        calculator = new Calculator();
    }

    @Test
    public void should_sum_all_expenses_of_a_person() {
        double sum = calculator.sum(person.getExpenses()).getResult();
        assertEquals(9, sum, 0);
    }

    @Test
    public void should_divide_by() {
        double forEach = calculator.sum(person.getExpenses()).divideBy(3).getResult();
        assertEquals(3, forEach, 0);
    }

}
