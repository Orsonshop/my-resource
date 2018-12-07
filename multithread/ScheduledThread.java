package multithread;
//定时或者循环执行线程
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.concurrent.*;

class  ScheduleTask implements  Runnable{
    private int taskId;
      @Override
    public void run() {
        LocalDateTime current=LocalDateTime.now();
        System.out.println(this.taskId+"  "+current);
    }
    public  ScheduleTask(int taskId){
        this.taskId=taskId;
    }
}
public class ScheduledThread {
    public static void main(String[] args) {
        int threadnum=3;
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(threadnum);   //延时或者循环
        ScheduleTask task1=new ScheduleTask(1);   //新建一个线程
        ScheduleTask task2=new ScheduleTask(2);
        Future t1=scheduledExecutorService.submit(task1);
        try {
            if(t1.get()==null) {
                System.out.println("tast1执行成功");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.execute(task2);

        //scheduledExecutorService.schedule(task1,2, TimeUnit.SECONDS);   //延后两秒执行1,定时执行器，注意与executor,submit的区别
        scheduledExecutorService.scheduleAtFixedRate(task2,0,10,TimeUnit.SECONDS); //立即执行2，每隔10秒执行一次
        try {
            TimeUnit.SECONDS.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();
    }

}
