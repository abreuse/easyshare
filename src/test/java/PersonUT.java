import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonUT {

    private Person person;

    @Before
    public void before() {
        person = new Person("test");
    }

    @Test
    public void should_add_an_expense() {

        person.addExpense(10.5);

        assertEquals(person.getExpenses().size(), 1);
    }

    @Test
    public void should_remove_last_expense() {

        person.addExpense(5.24343);
        person.addExpense(8.433);
        person.removeLastExpense();

        assertEquals(person.getExpenses().size(), 1);
    }


}
