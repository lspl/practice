package visitor;

/**
 * @author lishunpu
 * @create 2017-07-17 19:00
 */
public class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
