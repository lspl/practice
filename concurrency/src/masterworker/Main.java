package masterworker;

import java.util.Random;

/**
 * @author lishunpu
 * @create 2017-07-10 14:23
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("可用的处理器：" + Runtime.getRuntime().availableProcessors());
        Master m = new Master(new Worker(), Runtime.getRuntime().availableProcessors());

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Task t = new Task(i, "task" + i, random.nextInt(1000));
            m.submit(t);
        }

        m.execute();
        Long start = System.currentTimeMillis();
        while (true) {
            if (m.isTerminate()) {
                long end = System.currentTimeMillis();
                int ret = m.getResult();
                System.out.println("最终结果：" + ret + ", 花费时间：" + (end - start));
                break;
            }
        }
    }
}
