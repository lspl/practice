package interpreter;

/**
 * from: https://www.runoob.com/design-pattern/interpreter-pattern.html
 * @author lishunpu
 * @create 2017-07-17 14:12
 *
 * note: 解释器模式
 *      用于评估语言的语法或表达式，实际中可以使用的场景较少。Java中如果遇到可以用expression4J代替
 */
public class InterpreterPatterDemo {
    //规则：Robert和John是男性
    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExperssion(robert, john);
    }

    //规则：Julie是一个已婚的女性
    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women?" + isMarriedWoman.interpret("Married Julie"));
    }

}
