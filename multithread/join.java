package multithread;
//jion的使用
public class join {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new mulitithread(),"t1");
        Thread t2=new Thread(new mulitithread(),"t2");
        Thread t3=new Thread(new mulitithread(),"t3");
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        System.out.println("all dead");

    }
}
