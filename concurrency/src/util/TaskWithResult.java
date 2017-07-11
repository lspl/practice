package util;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * from: http://www.cnblogs.com/wanqieddy/p/3853863.html
 * @author lishunpu
 * @create 2017-07-11 9:41
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        System.out.println("call()方法被自动调用,干活！！！" + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return"call()方法被自动调用，任务的结果是：" + id + ", " + Thread.currentThread().getName();
    }
}
