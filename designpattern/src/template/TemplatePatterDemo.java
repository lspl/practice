package template;

/**
 * from: https://www.runoob.com/design-pattern/template-pattern.html
 * @author lishunpu
 * @create 2017-07-17 18:46
 *
 * note: 模板模式
 *      在模板模式中，抽象类公开定义了执行它的方法的方式/模板。子类可以按需要重写方法实现，
 *   但调用将以抽象类中定义的方式进行。这种类型的设计模式属于行为型模式。
 */
public class TemplatePatterDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
