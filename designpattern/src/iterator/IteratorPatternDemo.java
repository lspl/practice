package iterator;

/**
 * from: https://www.runoob.com/design-pattern/iterator-pattern.html
 * @author lishunpu
 * @create 2017-07-17 14:35
 *
 * note: 迭代器模式
 *      常用于顺序访问集合对象的元素，而不需要知道集合对象的底层表示
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }
    }
}
