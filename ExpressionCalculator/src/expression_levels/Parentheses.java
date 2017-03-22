package expression_levels;

import enums.Operator;

/**
 * Created by Ilgiz on 06.09.2016.
 */
public class Parentheses extends Expression {


    public Parentheses(Operator operation) {
        super(operation);
    }

    /**
     * Unnecessary method, because parentheses value operator.
     * It can solve plus operator.
     *
     * @param left
     * @param right
     * @param operator
     * @return
     */

    @Override
    protected Integer calculateExpression(Integer left, Integer right, Operator operator) {

        switch (operator) {
            case PLUS:
                return left + right;

        }

        throw new RuntimeException("Unknown operator");
    }


    public static Expression createInstance(String string) {
        switch (string) {
            case "(":
                return new Parentheses(Operator.OPEN_PARENTHESES);
            case ")":
                return new Parentheses(Operator.CLOSE_PARENTHESES);
            default:
                return Factor.createInstance(string);
        }
    }


}
