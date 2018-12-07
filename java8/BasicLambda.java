package java8;

import multithread.BasicAtom;

import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class BasicLambda {
    private  static boolean isPrime(int number){
//        if(number<2){
//            return false;
//        }
//        for(int i=2;i<number;i++){
//            if(number % i==0){
//                return false;
//            }
//        }

        IntPredicate isDivisible = i->number%i!=0;

        return number>1&&IntStream.range(2,number).allMatch(isDivisible);
        //allmatch 将所有流中符合条件的传入，anymatch,只传一个，noneMatch，
    }

    public static void main(String[] args) {
        System.out.println(isPrime(13));
    }
}
//// 1. 不需要参数,返回值为 5
//() -> 5
//
//// 2. 接收一个参数(数字类型),返回其2倍的值
//        x -> 2 * x
//
//// 3. 接受2个参数(数字),并返回他们的差值
//        (x, y) -> x – y
//
//// 4. 接收2个int型整数,返回他们的和
//        (int x, int y) -> x + y
//
//// 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
//        (String s) -> System.out.print(s)