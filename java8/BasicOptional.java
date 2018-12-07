package java8;

import java.util.Optional;

public class BasicOptional {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        String my=null;
        Optional<String> str=Optional.ofNullable(my);  //of必须得有值，ofNullable可以为空
        System.out.println(str.orElse("hahaha"));
    }
}
