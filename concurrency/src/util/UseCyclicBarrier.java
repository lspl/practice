package util;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author lishunpu
 * @create 2017-07-11 8:15
 */
public class UseCyclicBarrier {
    static class Runner implements Runnable {
        private CyclicBarrier cb;
        private String name;

        public Runner(CyclicBarrier cb, String name) {
            this.cb = cb;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(new Random(3).nextInt());
                System.out.println(System.currentTimeMillis() + " " + name + " 准备OK.");
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + " " + name + " Go!!");
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2);
        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.submit(new Thread(new Runner(cb, "zhangsan")));
        pool.submit(new Thread(new Runner(cb, "lisi")));
        pool.submit(new Thread(new Runner(cb, "wangwu")));
        pool.submit(new Thread(new Runner(cb, "wangwu2")));
        pool.submit(new Thread(new Runner(cb, "wangwu3")));
        pool.submit(new Thread(new Runner(cb, "wangwu4")));
        pool.submit(new Thread(new Runner(cb, "wangwu5")));

        pool.shutdown();
    }
}
