package executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lishunpu
 * @create 2017-07-10 17:02
 */

class Temp extends Thread {
    public void run() {
        System.out.println(System.currentTimeMillis() + " run");
    }
}

public class ScheduleJob {
    public static void main(String[] args) {
        Temp command = new Temp();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        System.out.println(System.currentTimeMillis());
        ScheduledFuture<?> scheduleTask = scheduler.scheduleWithFixedDelay(command, 1, 3, TimeUnit.SECONDS);
    }
}
