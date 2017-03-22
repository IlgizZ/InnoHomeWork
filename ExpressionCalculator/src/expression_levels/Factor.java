package expression_levels;

import enums.Operator;

/**
 * Created by Ilgiz on 06.09.2016.
 */
public class Factor extends Expression {


    public Factor(Operator operation) {
        super(operation);
    }

    public Factor(Operator operation, Expression left, Expression right) {
        super(operation, left, right);
    }

    @Override
    protected Integer calculateExpression(Integer left, Integer right, Operator operator) {

        switch (operator) {

            case MULTIPLY:
                return left * right;

            case DIVISION:
                return left / right;

        }

        throw new RuntimeException("Unexpected operator in Factor level");
    }

    public static Expression createInstance(String string) {
        switch (string) {
            case "*":
                return new Factor(Operator.MULTIPLY);
            case "/":
                return new Factor(Operator.DIVISION);
            default:
                return Term.createInstance(string);
        }
    }
}
