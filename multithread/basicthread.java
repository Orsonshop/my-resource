package multithread;

public class basicthread extends Thread {


    public void run() {
        System.out.println("running   "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            Processing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end"+Thread.currentThread().getName());
    }

    private void Processing() throws InterruptedException {
        System.out.println("waiting");
        Thread.sleep(5000);
    }

    public basicthread(String name) {
        super(name);
    }
}
