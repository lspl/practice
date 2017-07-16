package abstractfactory;

/**
 * @author lishunpu
 * @create 2017-07-16 10:39
 */
public class ColorFactory extends AbstractFactory {
    @Override
    Color getColor(String color) {
        if (color == null) {
            return null;
        }

        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        }
        if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        }
        if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
