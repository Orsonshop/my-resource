package multithread;
//线程池的使用,使线程在线程池内能并发固定的数目
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class BasicTack implements Runnable{
    int taskId;
    int loopNum;
    public BasicTack(int taskId,int loopNum){
        this.loopNum=loopNum;
        this.taskId=taskId;
    }
    public void run(){
        for(int i=1;i<=loopNum;i++){  //每个循环3次
            System.out.println("Task: "+this.taskId+"   "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Task:   "+this.taskId);
                break;
            }
        }
    }
}
public class ThreadPool {    //线程池

    public static void main(String[] args) {
         int number=3;  //线程个数
         final int loopnum=3;   // 循环次数
         final int tasknum=5;   //任务数
        ExecutorService ex=Executors.newFixedThreadPool(number);  //线程池容纳3个
        for(int i=1;i<=tasknum;i++){   //创建5个线程
             BasicTack task=new BasicTack(i,loopnum);  //名字，循环次数
             ex.submit(task);   //
        }
        //ex.shutdown();   //加上会报错，执行完成主线程
    }

}

