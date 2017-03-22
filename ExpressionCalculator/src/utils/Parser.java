package utils;

import enums.Level;
import enums.Operator;
import expression_levels.Expression;
import expression_levels.ExpressionInteger;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ilgiz on 07.09.2016.
 */
public class Parser {
    private List<Expression> tokens;

    private boolean isNumberPart(char c) {
        return Character.isDigit(c);
    }

    private boolean isPartOfExpression(Expression token) {
        return token.getLeft() != null;
    }

    private int findOperator(int start, int end, List<Operator> operators) {
        int i = 0;
        for (Expression token : tokens) {
            if (i == end)
                break;
            if (start > 0) {
                start--;
                i++;
                continue;
            }
            if (isPartOfExpression(token)) {
                i++;
                continue;
            }
            for (Operator operator : operators) {
                if (token.getOperation().equals(operator))
                    return i;
            }
            i++;

        }
        return end;
    }

    private int findOperator(int start, int end, Operator operator) {
        int i = 0;
        for (Expression token : tokens) {
            if (start > 0) {
                start--;
                continue;
            }
            if (isPartOfExpression(token)) {
                i++;
                continue;
            }
            if (token.getOperation().equals(operator))
                return i;
            i++;
        }
        return end;
    }

    private int findLastOperator(int start, int end, Operator operator) {
        int last = -1;
        int i = 0;
        for (Expression token : tokens) {
            if (start > 0) {
                start--;
                continue;
            }
            if (isPartOfExpression(token)) {
                i++;
                continue;
            }
            if (token.getOperation().equals(operator)) {
                last = i;
            }
            i++;
        }
        return last;
    }

    private void createNodes(String str) {
        tokens = new LinkedList();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb = new StringBuilder();
            char c = str.charAt(i);

            if (c == ' ') {
                continue;
            }

            sb.append(c);

            if (isNumberPart(c)) {
                while (i + 1 < str.length() && isNumberPart(c = str.charAt(i + 1))) {
                    sb.append(c);
                    i++;
                }
                tokens.add(new ExpressionInteger(sb.toString()));
                continue;
            }
            if (Character.isAlphabetic(c)) {
                while (i + 1 < str.length() && Character.isAlphabetic(c = str.charAt(i + 1))) {
                    sb.append(c);
                    i++;
                }
            }
            tokens.add(Expression.createOperator(sb.toString()));
        }

    }

    private Expression parse(int start, int end) {
        return parseLevel(start, end, Level.LOGICAL);
    }

    private Expression parseLevel(int start, int end, Level level) {
        if (level == Level.INTEGER) {
            return tokens.get(start);
        }

        int opPlace = findOperator(start, end, level.getOperators());

        Expression left = parseLevel(start, opPlace, level.nextLevel());
        if (opPlace != end) {
            Expression right = parse(opPlace + 1, end);
            Expression result = tokens.get(opPlace);
            result.setLeft(left);
            result.setRight(right);
            return result;
        }

        return left;
    }

    private void parseParentheses() {
        while (hasParentheses()) {
            int start = 0;
            int end = tokens.size() - 1;
            int closePos = findOperator(start, end, Operator.CLOSE_PARENTHESES);
            int openPos = findLastOperator(start, end, Operator.OPEN_PARENTHESES);
            Expression expressionInParentheses = parseLevel(openPos + 1, closePos, Level.LOGICAL);
            for (int i = openPos; i <= closePos; i++) {
                tokens.remove(openPos);
            }
            tokens.add(openPos, expressionInParentheses);
        }
    }

    private boolean hasParentheses() {
        for (Expression node : tokens) {
            if (node.getOperation() == Operator.OPEN_PARENTHESES)
                return true;
        }
        return false;
    }


    public Expression parseExpression(String input) {
        createNodes(input);
        parseParentheses();
        return parse(0, tokens.size() - 1);
    }


}
