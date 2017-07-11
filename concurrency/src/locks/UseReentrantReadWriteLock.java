package locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lishunpu
 * @create 2017-07-11 16:33
 */
public class UseReentrantReadWriteLock {
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    public void read(){
        try {
            readLock.lock();
            System.out.println(System.currentTimeMillis() + " 当前线程:" + Thread.currentThread().getName() + "进入...");
            Thread.sleep(3000);
            System.out.println(System.currentTimeMillis() + " 当前线程:" + Thread.currentThread().getName() + "退出...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void write(){
        try {
            writeLock.lock();
            System.out.println(System.currentTimeMillis() + " 当前线程:" + Thread.currentThread().getName() + "进入...");
            Thread.sleep(3000);
            System.out.println(System.currentTimeMillis() + " 当前线程:" + Thread.currentThread().getName() + "退出...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {

        final UseReentrantReadWriteLock urrw = new UseReentrantReadWriteLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.read();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.read();
            }
        }, "t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.write();
            }
        }, "t3");
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.write();
            }
        }, "t4");

        //读读共享
		t1.start(); //R
		t2.start(); //R

        //读写互斥
//		t1.start(); // R
//		t3.start(); // W

        //写写互斥
//        t3.start();
//        t4.start();
    }
}
