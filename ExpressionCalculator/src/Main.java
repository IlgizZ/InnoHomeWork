import expression_levels.Expression;
import utils.Parser;

/**
 * Created by Ilgiz on 11.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Expression exp = parser.parseExpression("1 +12*(8+123)and5 > 1");

        System.out.println(exp.calculate());
//        System.out.println(exp.toJSON());
        exp = parser.parseExpression("3*(2*(3+10))");

        System.out.println(exp.calculate());
        exp.toJSON("out.txt");

    }
}
