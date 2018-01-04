import java.util.List;
import java.util.stream.Stream;

public class Calculator {

    private double result = 0;

    public Calculator sum(List<Double> expenses) {

        Stream<Double> stream = expenses.stream();
        this.result += stream.mapToDouble(n -> n).sum();
        return this;
    }

    public Calculator divideBy(int diviser) {

        this.result /= diviser;
        return this;
    }

    public Calculator calculateRefundToOther(Person myself, Person otherPerson) {

        this.result += (otherPerson.getRefund() + otherPerson.getExtraExpenses().get(myself.getName()))
                - (myself.getRefund() + myself.getExtraExpenses().get(otherPerson.getName()));
        return this;
    }

    public void reset() {
        this.result = 0;
    }

    public double getResult() {
        return result;
    }
}
