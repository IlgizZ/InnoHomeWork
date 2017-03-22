package expression_levels;

import enums.Operator;

/**
 * Created by Ilgiz on 06.09.2016.
 */
public class Logical extends Expression {


    public Logical(Operator operation) {
        super(operation);
    }

    public Logical(Operator operation, Expression left, Expression right) {
        super(operation, left, right);
    }

    @Override
    protected Integer calculateExpression(Integer left, Integer right, Operator operator) {
        int l = left != 0 ? 1 : 0;
        int r = right != 0 ? 1 : 0;

        switch (operator) {

            case AND:
                return (l & r);

            case OR:
                return (l | r);

            case XOR:
                return (l ^ r);

        }

        throw new RuntimeException("Unexpected operator in Logical level");
    }


    public static Expression createInstance(String string) {
        switch (string) {
            case "and":
                return new Logical(Operator.AND);
            case "or":
                return new Logical(Operator.OR);
            case "xor":
                return new Logical(Operator.XOR);

        }
        return new Logical(Operator.NONE);
    }

}
