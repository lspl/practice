package locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lishunpu
 * @create 2017-07-11 15:03
 */
public class UseReentrantLock {
    private Lock lock = new ReentrantLock();

    public void method1() {
        try {
            lock.lock();
            System.out.println(System.currentTimeMillis() + " 线程" +Thread.currentThread().getName() + "进入method1()");
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis() + " 线程" +Thread.currentThread().getName() + "离开method1()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void method2() {
        try {
            lock.lock();
            System.out.println(System.currentTimeMillis() + " 线程" + Thread.currentThread().getName() + "进入method2()");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(System.currentTimeMillis() + " 线程" + Thread.currentThread().getName() + "离开method2()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final UseReentrantLock lock = new UseReentrantLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.method1();
                lock.method2();
            }
        }, "t1");

        t1.start();
    }
}
