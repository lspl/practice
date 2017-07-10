package util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author lishunpu
 * @create 2017-07-10 20:35
 */
public class UseCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch count = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            try {
                System.out.println(System.currentTimeMillis() + " 进入" + Thread.currentThread().getName() + ", 等待其他线程初始化资源");
                count.await();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + "线程继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                System.out.println(System.currentTimeMillis() + " 进入" + Thread.currentThread().getName() + ", 开始初始化...");
                TimeUnit.SECONDS.sleep(2);
                count.countDown();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + "线程初始化完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");

        Thread t3 = new Thread(() -> {
            try {
                System.out.println(System.currentTimeMillis() + " 进入" + Thread.currentThread().getName() + ", 开始初始化...");
                TimeUnit.SECONDS.sleep(3);
                count.countDown();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + "线程初始化完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
