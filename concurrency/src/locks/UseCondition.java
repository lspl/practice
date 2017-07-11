package locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lishunpu
 * @create 2017-07-11 15:31
 */
public class UseCondition {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void method1() {
        try {
            lock.lock();
            System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " method1()进入等待状态");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " method1()释放锁");
            condition.await();
            System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " method1()继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void method2(){
        try {
            lock.lock();
            System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " 进入method2()");
            Thread.sleep(3000);
            System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " method2()发出唤醒");
            condition.signal();		//Object notify
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final UseCondition uc = new UseCondition();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.method1();
            }
        }, "t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.method2();
            }
        }, "t2");
        t2.start();
    }

}
