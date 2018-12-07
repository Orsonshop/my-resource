package multithread;

public class text {
    public static void main(String[] args) throws InterruptedException {
       Thread t1=new Thread(new mulitithread(),"t1");
        Thread t2=new Thread(new mulitithread(),"t2");
        System.out.println("start  process");
        t1.start();
        t1.join();   //t2执行完才执行 t1
        t2.start();   //start启动线程，线程处于就绪状态，并不一定立即执行，而是交给cpu调度
        System.out.println("end");
        Thread t3=new basicthread("t3");
        Thread t4=new basicthread("t4");
        System.out.println("start");
        t3.start();
        t4.start();

        System.out.println("end");  //两个结束时间不一定
    }
}
