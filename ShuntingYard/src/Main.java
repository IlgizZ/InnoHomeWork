/**
 * Created by Ilgiz on 31.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            String s = MyReaderWriter.readInput("input.txt");
            ShuntingYardConverter shuntingYard = new ShuntingYardConverter();
            String result = new RPNSolver().solve(shuntingYard.convertToRPN(s));
            MyReaderWriter.writeToFile("output.txt", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
