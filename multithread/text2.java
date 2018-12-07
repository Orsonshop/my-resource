package multithread;

public class text2 {
    public static void main(String[] args) throws InterruptedException {
        Thread dt=new Thread(new daemonthead(),"dt");
        dt.setDaemon(true);//设置为守护进程，主线程结束则结束
        dt.start();
        Thread.sleep(5000);
        System.out.println("完成");
    }
}
