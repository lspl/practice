package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lishunpu
 * @create 2017-07-10 16:19
 */
public class UseExecutor extends Thread{
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        MyTask t1 = new MyTask(1, "t1");
        MyTask t2 = new MyTask(2, "t2");
        MyTask t3 = new MyTask(3, "t3");
        MyTask t4 = new MyTask(4, "t4");
        MyTask t5 = new MyTask(5, "t5");

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        pool.shutdown();
    }
    /*
    1499687715319, run taskId =1
    1499687715319, run taskId =2
    1499687715320, run taskId =3
    1499687718378, run taskId =4
    1499687718378, run taskId =5
     */
}
