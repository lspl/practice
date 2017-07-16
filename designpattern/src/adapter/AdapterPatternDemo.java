package adapter;

/**
 * from: http://www.runoob.com/design-pattern/adapter-pattern.html
 * @author lishunpu
 * @create 2017-07-16 18:53
 *
 * note: 适配器模式
 *      作为两个不兼容的接口之间的桥梁。
 *      比如：读卡器作为内存卡和笔记本之间的适配器。将内存卡插入读卡器，再将读卡器插入笔记本，这样既可以通过笔记本来读取内存卡
 * 个人理解：
 *      使用场景：在不修改原来接口的基础上扩展系统的功能
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
