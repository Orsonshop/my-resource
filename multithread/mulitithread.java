package multithread;

public class mulitithread implements Runnable{

    @Override
    public void run() {
        System.out.println("start   "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            Processing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end   "+Thread.currentThread().getName());
    }

    private void Processing() throws InterruptedException {
        System.out.println("waiting");
        Thread.sleep(5000);
    }

}
