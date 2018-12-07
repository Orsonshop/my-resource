package java8;

import java.util.function.Consumer;

public class BasicFunctioninterface {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer.accept("@@@");
    }
}
