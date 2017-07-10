package masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lishunpu
 * @create 2017-07-10 14:23
 */
public class Worker extends Thread{
    private ConcurrentLinkedQueue<Task> tasks = new ConcurrentLinkedQueue<Task>();
    private ConcurrentHashMap<Task, Integer> concurrentMap = new ConcurrentHashMap<Task, Integer>();

    public void setTasks(ConcurrentLinkedQueue<Task> tasks) {
        this.tasks = tasks;
    }

    public void setConcurrentMap(ConcurrentHashMap<Task, Integer> concurrentMap) {
        this.concurrentMap = concurrentMap;
    }

    @Override
    public void run() {
        while (!tasks.isEmpty()) {
            Task t = tasks.poll();
            concurrentMap.put(t, process(t));
        }
    }

    public Integer process(Task t) {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return t.getPrice();
    }
}
