package utils;

import enums.Operator;
import expression_levels.Expression;
import expression_levels.ExpressionInteger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Ilgiz on 21.07.2016.
 */
public class ExpressionConverter {

    private int spaceCount;
    private StringBuilder sb;

    public void convert(Expression expr, String fileName) {
        convert(expr);
        writeToFile(fileName);
    }

    public String convert(Expression expr) {
        sb = new StringBuilder();

        sb.append("{");
        newLine();
        incSpace();
        writeObjectWithOpenParenthesis("Expression");

        writeExpression(expr);

        writeCloseParenthesis();

        writeCloseParenthesis();
        return sb.toString();
    }

    private void writeExpression(Expression expr) {
        if (expr.getOperation() == Operator.INTEGER) {
            writeKeyValue(Operator.INTEGER.toString(), ((ExpressionInteger) expr).getValue().toString());
            return;
        }
        writeKeyValue("operation", expr.getOperation().toString());
        writeObjectWithOpenParenthesis("left");
        writeExpression(expr.getLeft());
        writeCloseParenthesis();

        writeObjectWithOpenParenthesis("right");
        writeExpression(expr.getRight());
        writeCloseParenthesis();
    }

    private void writeKeyValue(String s, String value) {
        sb.append(getCurrentSpace());
        sb.append("\"");
        sb.append(s);
        sb.append("\": \"");
        sb.append(value);
        sb.append("\",");
        newLine();
    }

    private void incSpace() {
        spaceCount += 4;
    }

    private void decSpace() {
        spaceCount -= 4;
    }

    private String getCurrentSpace() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spaceCount; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private void writeObjectWithOpenParenthesis(String object) {
        sb.append(getCurrentSpace());
        sb.append("\"");
        sb.append(object);
        sb.append("\": {");
        incSpace();
        newLine();
    }

    private void writeCloseParenthesis() {
        decSpace();
        sb.append(getCurrentSpace());
        sb.append("}");
        newLine();
    }

    private void newLine() {
        sb.append("\n");
    }

    private void writeText(String text) {
        sb.append(text);
    }

    private void writeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)))) {

            writer.write(sb.toString());
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
