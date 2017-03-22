package expression_levels;

import enums.Operator;

/**
 * Created by Ilgiz on 06.09.2016.
 */
public class ExpressionInteger extends Expression {

    private Integer value;

    public ExpressionInteger(String str) {
        super(Operator.INTEGER);
        value = Integer.valueOf(str);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Unnecessary method, because Integer value haven't operator.
     * It can solve plus, minus, multiply and division operators.
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

            case MINUS:
                return left - right;

            case MULTIPLY:
                return left * right;

            case DIVISION:
                return left / right;

        }

        throw new RuntimeException("Unknown operator");
    }
}
