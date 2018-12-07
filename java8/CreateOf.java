package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class CreateOf {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("im'm orson");
        stream.forEach(System.out::println);

        Stream<String> stream1=Stream.of("java","ptyhon","go");
        stream1.forEach(s->System.out.println("<<"+s+">>"));

        String[]names={"web","imperative"};
        Stream<String> stream2=Stream.of(names);
        stream2.forEach(System.out::println);


        Stream<String> stream3= Arrays.asList(names).stream();
        stream3.forEach(System.out::println);




    }
}
