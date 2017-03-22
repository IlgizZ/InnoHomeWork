package expression_levels;

import enums.Operator;
import utils.ExpressionConverter;

/**
 * Created by Ilgiz on 06.09.2016.
 */
public abstract class Expression {

    private Operator operation;
    private Expression left, right;

    public Operator getOperation() {
        return operation;
    }

    public void setOperation(Operator operation) {
        this.operation = operation;
    }

    public Expression(Operator operation) {
        this.operation = operation;
    }

    public Expression(Operator operation, Expression left, Expression right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public static Expression createOperator(String s) {
        return Parentheses.createInstance(s);
    }

    public Integer calculate() {

        if (operation == Operator.INTEGER) {
            return ((ExpressionInteger) this).getValue();
        }

        Integer left, right;

        left = this.left.calculate();
        right = this.right.calculate();
        Operator operator = this.getOperation();

        return this.calculateExpression(left, right, operator);
    }

    protected abstract Integer calculateExpression(Integer left, Integer right, Operator operator);

    public void toJSON(String fileName) {
        (new ExpressionConverter()).convert(this, fileName);
    }

    public String toJSON() {
        return (new ExpressionConverter()).convert(this);
    }
}
