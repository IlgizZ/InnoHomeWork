import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Ilgiz on 31.08.2016.
 */
public class RPNSolver {

    private String doubleConverter(Double d) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(d);
    }

    public String solve(MyLinkedQueue<String> queue) throws Exception {
        MyLinkedStack<Double> stack = new MyLinkedStack();

        while (!queue.isEmpty()) {
            String symbol = queue.dequeue();
            if (!ShuntingYardConverter.isOperator(symbol)) {
                stack.push(Double.valueOf(symbol));
            } else {
                Double b = stack.pop();
                Double a = stack.pop();
                if (a == null || b == null) {
                    throw new Exception("Incorrect RPN!");
                }
                switch (symbol) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "−":
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }

        return doubleConverter(stack.pop());
    }
}
