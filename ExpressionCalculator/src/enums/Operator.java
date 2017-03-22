package enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 07.09.2016.
 */
public enum Operator {
    AND("and"), OR("or"), XOR("xor"),
    LESS("<"), LESS_EQUAL("<="), GREATER(">"), GREATER_EQUAL(">="), EQUAL("="), NOT_EQUAL("!="),
    PLUS("+"), MINUS("-"),
    MULTIPLY("*"), DIVISION("/"),
    OPEN_PARENTHESES("("), CLOSE_PARENTHESES(")"),
    INTEGER("integer"),
    NONE("");

    private String value;

    Operator(String value) {
        this.value = value;
    }

    public static List<Operator> getLogical() {
        List result = new ArrayList();
        result.add(AND);
        result.add(OR);
        result.add(XOR);
        return result;
    }

    public static List<Operator> getRelation() {
        List result = new ArrayList();
        result.add(LESS);
        result.add(LESS_EQUAL);
        result.add(GREATER);
        result.add(GREATER_EQUAL);
        result.add(EQUAL);
        result.add(NOT_EQUAL);
        return result;
    }

    public static List<Operator> getTerm() {
        List result = new ArrayList();
        result.add(PLUS);
        result.add(MINUS);
        return result;
    }

    public static List<Operator> getFactor() {
        List result = new ArrayList();
        result.add(MULTIPLY);
        result.add(DIVISION);
        return result;
    }

    public static List<Operator> getParentheses() {
        List result = new ArrayList();
        result.add(OPEN_PARENTHESES);
        result.add(CLOSE_PARENTHESES);
        return result;
    }


    public static List<Operator> getNone() {
        List result = new ArrayList();
        result.add(NONE);
        return result;
    }
}
