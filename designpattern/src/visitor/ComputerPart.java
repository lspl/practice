package visitor;

/**
 * @author lishunpu
 * @create 2017-07-17 18:59
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
