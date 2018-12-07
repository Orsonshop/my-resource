package multithread;

import java.util.Date;
import java.util.TimerTask;   //java工具

public class timerthread extends TimerTask {


    @Override
    public void run() {
        System.out.println("timer task started at"+new Date());
        process();
        System.out.println("timer task ended at"+new Date());

    }

    private void process() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
