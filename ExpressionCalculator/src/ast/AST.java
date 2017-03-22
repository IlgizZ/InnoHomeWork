package ast;

import enums.Operator;
import expression_levels.Expression;
import expression_levels.ExpressionInteger;

/**
 * Created by Ilgiz on 06.09.2016.
 */

/**
 * Class created for 3rd Assignment
 */

public class AST {
    private TreeNode root;

    public AST(Expression expression) {
        root = setNode(expression, null);
    }

    private TreeNode setNode(Expression expression, TreeNode prev) {
        if (expression == null)
            return null;

        TreeNode result = null;
        Operator operator = expression.getOperation();

        if (operator == Operator.INTEGER) {
            result = new TreeNode(((ExpressionInteger) expression).getValue());
        } else {
            result = new TreeNode(operator);
        }

        result.setLeft(setNode(expression.getLeft(), result));
        result.setRight(setNode(expression.getRight(), result));

        return result;
    }

    public double calculate() {
        return calculate(root);
    }

    private Double calculate(TreeNode node) {

        if (node.getLeft() == null && node.getLeft() == null) {
            return (Double) node.getData();
        }

        Double left, right;

        left = calculate(node.getLeft());

        right = calculate(node.getRight());
        Operator operator = (Operator) node.getData();

        return calculateExpression(left, right, operator);
    }

    private double calculateExpression(Double left, Double right, Operator operator) {
        double eps = 0.0000001;
        int l;
        int r;
        switch (operator) {
            case AND:
                l = left.intValue() != 0 ? 1 : 0;
                r = left.intValue() != 0 ? 1 : 0;
                return l & r;

            case OR:
                l = left.intValue() != 0 ? 1 : 0;
                r = left.intValue() != 0 ? 1 : 0;
                return l | r;

            case XOR:
                l = left.intValue() != 0 ? 1 : 0;
                r = left.intValue() != 0 ? 1 : 0;
                return l ^ r;

            case LESS:
                return left < right ? 1 : 0;

            case LESS_EQUAL:
                return left - right <= eps ? 1 : 0;

            case GREATER:
                return left > right ? 1 : 0;

            case GREATER_EQUAL:
                return left - right > eps ? 1 : 0;

            case EQUAL:
                return Math.abs(left - right) <= eps ? 1 : 0;

            case NOT_EQUAL:
                return Math.abs(left - right) > eps ? 1 : 0;

            case PLUS:
                return left + right;

            case MINUS:
                return left - right;

            case MULTIPLY:
                return left * right;

            case DIVISION:
                return left / right;

        }
        return 0;
    }
}
