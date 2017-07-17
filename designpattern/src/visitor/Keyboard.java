package visitor;

/**
 * @author lishunpu
 * @create 2017-07-17 18:59
 */
public class Keyboard implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
