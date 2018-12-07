package java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class CreateCollection {
    public static void main(String[] args) {

        Stream<String> classes1 = Arrays.stream(new String[]{"java", "2018"});
        Stream<String> classes = Arrays.asList(new String[]{"java", "2018"}).stream();
        classes.forEach(System.out::println);

        Set<String> names=new HashSet<>();
        names.add("java");
        names.add("2018");
        names.stream().forEach(System.out::println);

        names.parallelStream().forEach(System.out::println);
    }
}
