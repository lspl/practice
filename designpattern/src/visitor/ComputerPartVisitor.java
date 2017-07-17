package visitor;

/**
 * @author lishunpu
 * @create 2017-07-17 19:04
 */
public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
}
