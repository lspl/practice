package interpreter;

/**
 * @author lishunpu
 * @create 2017-07-17 14:09
 */
public class OrExperssion implements Expression {
    private Expression expr1 = null;
    private Expression expr2 = null;

    public OrExperssion(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}
