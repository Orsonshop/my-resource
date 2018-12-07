package java8;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class BasicOptinalStream {
    public static void main(String[] args) {
        //optianal不允许传空值，除非用ofnullable传
        OptionalInt maxOdd= IntStream.of(10,20,30,40)
                .filter(n->n%2==1)
                .max();    //找出奇数最大值
        if(maxOdd.isPresent()){    //判断是否有值
            System.out.println(maxOdd.getAsInt());   //转化为int
        }else{
            System.out.println("not exists");
        }
        System.out.println(maxOdd.orElse(-1));   //判断存在-1
    }
}
