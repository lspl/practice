package proxy;

/**
 * @author lishunpu
 * @create 2017-07-17 9:50
 */
public class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    protected void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}
