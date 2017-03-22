package expression_levels;

import enums.Operator;

/**
 * Created by Ilgiz on 06.09.2016.
 */
public class Relation extends Expression {


    public Relation(Operator operation) {
        super(operation);
    }

    public Relation(Operator operation, Expression left, Expression right) {
        super(operation, left, right);
    }

    @Override
    protected Integer calculateExpression(Integer left, Integer right, Operator operator) {

        switch (operator) {

            case LESS:
                return (left < right ? 1 : 0);

            case LESS_EQUAL:
                return (left <= right ? 1 : 0);

            case GREATER:
                return (left > right ? 1 : 0);

            case GREATER_EQUAL:
                return (left > right  ? 1 : 0);

            case EQUAL:
                return ((left == right) ? 1 : 0);

            case NOT_EQUAL:
                return ((left != right) ? 1 : 0);


        }

        throw new RuntimeException("Unexpected operator in Relation level");
    }

    public static Expression createInstance(String string) {
        switch (string) {
            case "<":
                return new Relation(Operator.LESS);
            case "<=":
                return new Relation(Operator.LESS_EQUAL);
            case ">":
                return new Relation(Operator.GREATER);
            case ">=":
                return new Relation(Operator.GREATER_EQUAL);
            case "=":
                return new Relation(Operator.EQUAL);
            case "!=":
                return new Relation(Operator.NOT_EQUAL);
            default:
                return Logical.createInstance(string);
        }
    }


}
