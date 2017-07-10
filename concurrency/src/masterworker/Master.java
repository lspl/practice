package masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author lishunpu
 * @create 2017-07-10 14:23
 */
public class Master {
    // 用于存放所有的任务
    private ConcurrentLinkedQueue<Task> tasks = new ConcurrentLinkedQueue<Task>();

    // 将任务和其运行的线程进行绑定
    private Map<String, Thread> threads = new HashMap<String, Thread>();

    // 获得每个任务的运行结果
    private ConcurrentHashMap<Task, Integer> concurrentMap = new ConcurrentHashMap<Task, Integer>();

    public Master(Worker worker, int workerCount) {
        worker.setConcurrentMap(concurrentMap);
        worker.setTasks(tasks);
        for (int i = 0; i < workerCount; i++) {
            threads.put("子节点" + i, new Thread(worker));
        }
    }

    public void submit(Task t) {
        this.tasks.add(t);
    }

    public void execute() {
        for (Map.Entry<String, Thread> me : threads.entrySet()) {
            me.getValue().start();
        }
    }

    public boolean isTerminate() {
        for (Map.Entry<String, Thread> me : threads.entrySet()) {
            if (me.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    public int getResult() {
        int ret = 0;
        for (Map.Entry<Task, Integer> me : concurrentMap.entrySet()) {
            ret += me.getValue();
        }
        return ret;
    }
 }
