package multithread;

public class daemonthead implements Runnable{

    @Override
    public void run() {
        while (true){
            processing();

        }
    }

    private void processing()  {
        System.out.println("我正在守护你");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
