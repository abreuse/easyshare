import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Scanner {

    private static java.util.Scanner keyboard = new java.util.Scanner(System.in);

    public static List<Person> scanPersons() {

        List<Person> persons = new ArrayList<>();

        System.out.println("Enter the names (enter nothing to end) :");

        while (true) {

           String name = keyboard.nextLine();

            if(name.equals(""))
                break;

            persons.add(new Person(name));
        }

        return persons;
    }


    public static List<Double> scanSelfExpenses(Person person) {

        return scanExpenses(person, null);
    }


    public static List<Double> scanExpensesForOtherFullyPayedByMyself(Person person, Person otherPerson) {

        return scanExpenses(person, otherPerson);
    }


    private static List<Double> scanExpenses(Person person, Person otherPerson) {

        List<Double> expenses = new ArrayList<>();

        if(null == otherPerson)
            System.out.println("Expenses for " + person.getName() + " (enter '0' to end) :");

        else
            System.out.println("Expenses for " + otherPerson.getName() + " payed by " + person.getName()
                    + " (enter '0' to end) :");

        while(true) {

            try {
                double expense = keyboard.nextDouble();

                if (expense == 0)
                    break;

                expenses.add(expense);
            }
            catch (InputMismatchException e) {
                System.err.println("Utilisez les virgules au lieu des points.");
                keyboard.next();
            }
        }

        return expenses;
    }

    public static boolean askIfAnyExtraExpenses() {

        System.out.println("Is there any extra expenses ? (y or n) :");

        String choice = keyboard.next();

        return choice.equals("y") || choice.equals("yes");
    }
}
