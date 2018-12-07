package multithread;
//守护线程
import java.util.Timer;
import java.util.TimerTask;

public class text3 {
    public static void main(String[] args) {
        TimerTask timerTask=new timerthread();
        Timer timer = new Timer(true);   //守护线程
        timer.scheduleAtFixedRate(timerTask,0,4*1000);  //执行线程，初始化时延，每隔4秒执行一次timerTask
        System.out.println("start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
