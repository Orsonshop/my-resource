package multithread.folkandjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

class QuickSort{
    private static int partition(Long[] numbers,int low,int high){
        Long soldier =numbers[low];
        while(low<high) {
            while (low < high) {
                if (numbers[high] < soldier) {
                    numbers[low] = numbers[high];
                    break;
                }
                high--;
            }
            while (low < high) {
                if (numbers[low] > soldier) {
                    numbers[high] = numbers[low];
                    break;
                }
                low++;
            }
        }
        numbers[low]=soldier;
        return low;
    }
    public static void qsort(Long[] numbers,int low,int high){
        if(low<high){
            int soldier = partition(numbers,low,high);
            qsort(numbers,low,soldier-1);
            qsort(numbers,soldier+1,high);
        }
    }
}
class ParalleQuickSort extends RecursiveAction {

    private int threadhold = 30;
    private int low;
    private int high;
    private Long[] numbers;

    public ParalleQuickSort(int threadhold, Long[] numbers) {
        this.threadhold = threadhold;
        this.low=0;
        this.high=numbers.length-1;
        this.numbers = numbers;
    }

    public ParalleQuickSort(int low, int high, Long[] numbers) {

        this.low = low;
        this.high = high;
        this.numbers = numbers;
    }

    private static int partition(Long[] numbers, int low, int high) {
        Long soldier = numbers[low];
        while (low < high) {
            while (low < high) {
                if (numbers[high] < soldier) {
                    numbers[low] = numbers[high];
                    break;
                }
                high--;
            }
            while (low < high) {
                if (numbers[low] > soldier) {
                    numbers[high] = numbers[low];
                    break;
                }
                low++;
            }
        }
        numbers[low] = soldier;
        return low;

    }

    @Override
    protected void compute() {
        if (high - low < threadhold) {
            QuickSort.qsort(numbers, low, high);
        } else {
            int soldier = partition(numbers, low, high);
            ParalleQuickSort left = new ParalleQuickSort(low, soldier - 1, numbers);
            ParalleQuickSort right = new ParalleQuickSort(soldier + 1, high, numbers);
            invokeAll(left, right);
        }
    }
}

public class MainSort {
    private static Long[] generateRandomNumber(int n){
        Random random =new Random();
        Long[] numbers =new Long[n];

        for(int i=0;i<n;i++){
            Long num =random.nextLong();
            if(num<0){
                num =Math.abs(num);
            }
            numbers[i]=num;
        }
        return numbers;
    }
    public static void main(String[] args) {
        final int RUN_TIMES =10;
        final int SORT_NUM = 10000000;
        final int THREADHOLD =36200;

        Long startTime;
        for(int i =0;i<RUN_TIMES+1;i++){
            System.out.println("The "+i+" run:");
            System.out.println("Generating "+SORT_NUM+" numbers");

            Long[] qsNumbers =generateRandomNumber(SORT_NUM);
            System.out.println("Executing QuickSort");
            startTime = System.currentTimeMillis();
            QuickSort.qsort(qsNumbers,0,qsNumbers.length-1);
            Long qsRunTime =(System.currentTimeMillis()-startTime)/1000;
            System.out.println("Total use: "+qsRunTime+" s");

            Long[] pqsNumbers =generateRandomNumber(SORT_NUM);
            System.out.println("Executing Parallel QuickSort");
            ForkJoinPool pool =new ForkJoinPool();
            ParalleQuickSort paralleQuickSort =new ParalleQuickSort(THREADHOLD,pqsNumbers);
            startTime=System.currentTimeMillis();
            pool.execute(paralleQuickSort);
            while(!paralleQuickSort.isDone()){

            }
            Long pqsRunnTime =System.currentTimeMillis()-startTime;
            System.out.println("Total use: "+pqsRunnTime+" ms\n");
        }
    }
}
