import java.util.List;

public class Main {

    public static void main(String args[]) {

        Calculator calculator = new Calculator();

        List<Person> persons = setPersons();
        setExpensesAndCalculateRefundsForEachPerson(persons, calculator);
        displayRefundsForEachPerson(persons);

        if(Scanner.askIfAnyExtraExpenses())
            calculateExtraExpenses(persons, calculator);

        recalculateRefundsWithExtraExpensesAndDisplay(persons, calculator);
    }


    private static List<Person> setPersons() {
        List<Person> persons = Scanner.scanPersons();

        initExtraExpenses(persons);

        System.out.println(persons.size() + " personnes : " + persons);
        System.out.println();
        return persons;
    }

    private static void initExtraExpenses(List<Person> persons) {
        for(Person myself : persons)
            for(Person otherPerson : persons)
            {
                if(myself.getName().equals(otherPerson.getName()))
                    continue;

                myself.getExtraExpenses().put(otherPerson.getName(), 0d);
            }
    }


    private static void setExpensesAndCalculateRefundsForEachPerson(List<Person> persons, Calculator calculator) {

        for (Person person : persons) {
            person.setExpenses(Scanner.scanSelfExpenses(person));
            person.setRefund(calculator.sum(person.getExpenses()).divideBy(persons.size()).getResult());
            calculator.reset();
        }
    }


    private static void displayRefundsForEachPerson(List<Person> persons) {

        System.out.println("\n ***********************");
        System.out.println(" SUMS FOR EACH PERSON ");
        System.out.println("***********************");

        for (Person person : persons)
            System.out.println(person.getName() + " : " + person.getRefund());

        System.out.println();
        System.out.println();
    }


    private static void calculateExtraExpenses(List<Person> persons, Calculator calculator) {

        for(Person myself : persons) {
            for(Person otherPerson : persons) {

                if(myself.getName().equals(otherPerson.getName()))
                    continue;

                double extraExpenses = calculator.sum(
                        Scanner.scanExpensesForOtherFullyPayedByMyself(myself, otherPerson)
                ).getResult();

                calculator.reset();

                myself.getExtraExpenses().replace(otherPerson.getName(), extraExpenses);
            }
        }
    }


    private static void recalculateRefundsWithExtraExpensesAndDisplay(List<Person> persons, Calculator calculator) {

        System.out.println("\n**************");
        System.out.println("  REFUNDING  ");
        System.out.println("**************\n");

        for (Person myself : persons)
        {
            for(Person otherPerson : persons)
            {
                if(myself.getName().equals(otherPerson.getName()))
                    continue;

                double refundToOther = calculator.calculateRefundToOther(myself, otherPerson).getResult();

                calculator.reset();

                if(refundToOther < 0)
                    refundToOther = 0;

                System.out.println(myself.getName() + " -> " + otherPerson.getName() + " : " + refundToOther);

            }
            System.out.println();
        }
    }
}
