package java8;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateIterate {
    public static void main(String[] args) {
        Stream.iterate(1,n->n+1)
                .filter(n->n%2!=0)  // 过滤偶数
                .skip(5)            //跳过5个
                .limit(5)           //限制5个
                .forEach(System.out::println);
        IntStream.rangeClosed(1,10) //左闭右闭区间
                .map(n->n*n)         //一对一映射
                .forEach(System.out::println);
        Stream.of(1,2,3)
                .flatMap(n -> Stream.of(n,n+1))   //扁平化，一对多映射，1映射为1，2
                .filter((n->n<3))
                .forEach(System.out::println);

        int sum=Arrays.asList(1,2,3,4,5,6,7,8,9,10)
                .stream()
                .reduce(0,Integer::sum);  //归纳
        System.out.println(sum);

        DoubleSummaryStatistics statistics=new DoubleSummaryStatistics();
        statistics.accept(100.0);
        statistics.accept(108.0);
        statistics.accept(12.25);
        long count =statistics.getCount();
        double sum1=statistics.getSum();
        double sum2=statistics.getMax();
        double  sum3=statistics.getMin();
        double  sum4=statistics.getAverage();
        System.out.println("Sum="+sum1+"  "+"Max="+sum2+"   "+"Min="+sum3+"   "+"Average="+sum4);

    }
}
