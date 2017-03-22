package expression_levels;

import enums.Operator;

/**
 * Created by Ilgiz on 06.09.2016.
 */
public class Term extends Expression {

    public Term(Operator operation) {
        super(operation);
    }

    public Term(Operator operation, Expression left, Expression right) {
        super(operation, left, right);
    }

    @Override
    protected Integer calculateExpression(Integer left, Integer right, Operator operator) {
        switch (operator) {
            case PLUS:
                return left + right;

            case MINUS:
                return left - right;

        }

        throw new RuntimeException("Unexpected operator in Term level");
    }

    public static Expression createInstance(String string) {
        switch (string) {
            case "+":
                return new Term(Operator.PLUS);
            case "-":
                return new Term(Operator.MINUS);
            default:
                return Relation.createInstance(string);
        }
    }
}
