package visitor;

/**
 * @author lishunpu
 * @create 2017-07-17 19:01
 */
public class Mouse implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
