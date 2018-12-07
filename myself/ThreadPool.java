package myself;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadPool implements Runnable{
    @Override
    public void run() {
        try {
            process();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void process() {

        System.out.println("***"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(3);
        ThreadPool t1=new ThreadPool();
        ThreadPool t2=new ThreadPool();
        for(int i=0;i<6;i++) {
            scheduledExecutorService.submit(t1);
        }

    }

}

