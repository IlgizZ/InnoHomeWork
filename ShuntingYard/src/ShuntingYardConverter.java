/**
 * Created by Ilgiz on 31.08.2016.
 */
public class ShuntingYardConverter {

    public interface Symbol {

    }

    private enum Operator implements Symbol {

        PLUS('+', 1), MINUS('-', 1), MULTIPLY('*', 2), DIVIDE('/', 2);

        private char value;
        private int priority;

        Operator(char value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public boolean isNotBiggerThan(Symbol symbol) {
            return (symbol instanceof Operator)
                    && this.priority <= ((Operator) symbol).priority;
        }
    }

    private enum Parenthesis implements Symbol {
        OPEN_PARENTHESIS('('), CLOSE_PARENTHESIS(')');

        private char value;

        Parenthesis(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private boolean isBracket(Object o) {
        return o instanceof Parenthesis;
    }

    private boolean isNumberPart(char c) {
        return Character.isDigit(c) || (c == '.') || (c == ',');
    }

    private static Symbol createSymbolByValue(String s) {
        switch (s) {
            case "+":
                return Operator.PLUS;
            case "−":
            case "-":
                return Operator.MINUS;
            case "*":
                return Operator.MULTIPLY;
            case "/":
                return Operator.DIVIDE;
            case "(":
                return Parenthesis.OPEN_PARENTHESIS;
            case ")":
                return Parenthesis.CLOSE_PARENTHESIS;
        }
        return null;
    }

    private void processSymbol(MyLinkedStack<Symbol> stack, MyLinkedQueue<String> output, char c) throws Exception {
        Symbol symbol = createSymbolByValue(String.valueOf(c));

        if (isOperator(symbol)) {

            while (((Operator) symbol).isNotBiggerThan(stack.top())) {
                output.enqueue(stack.pop().toString());
            }

            stack.push(symbol);

        } else if (isBracket(symbol)) {

            if (symbol.equals(Parenthesis.OPEN_PARENTHESIS)) {
                stack.push(symbol);
            } else {
                while (!(symbol = stack.pop()).equals(Parenthesis.OPEN_PARENTHESIS)) {
                    output.enqueue(symbol.toString());
                    if (stack.isEmpty()) {
                        throw new Exception("Incorrect expression! Missed parenthesis!");
                    }
                }
            }

        }
    }

    public MyLinkedQueue<String> convertToRPN(String str) throws Exception {

        MyLinkedStack<Symbol> stack = new MyLinkedStack();
        MyLinkedQueue<String> output = new MyLinkedQueue();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb = new StringBuilder();
            char c = str.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (isNumberPart(c)) {
                sb.append(c);
                while (i + 1 < str.length() && isNumberPart(c = str.charAt(i + 1))) {
                    sb.append(c);
                    i++;
                }
                output.enqueue(sb.toString());
                continue;
            } else if (Character.isAlphabetic(c)) {
                output.enqueue(String.valueOf(c));
                continue;
            } else {
                processSymbol(stack, output, c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.top().equals(Parenthesis.OPEN_PARENTHESIS)) {
                throw new Exception("Incorrect expression! Unclosed parenthesis!");
            }
            output.enqueue(stack.pop().toString());
        }

        return output;
    }

    public static boolean isOperator(Object o) {
        o = createSymbolByValue(o.toString());
        return o instanceof Operator;
    }
}
