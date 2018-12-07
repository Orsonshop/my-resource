package java8;

import java.util.Iterator;
import java.util.Objects;

@FunctionalInterface
public interface BasicFunctional <T>{

   // boolean equals(Objects obj);
    int compare(T o1,T o2);
}



interface X{
    Iterator m(Iterator<String> arg);
}
interface Y{
    Iterator<String> m(Iterator arg);
}
@FunctionalInterface    //泛型对返回值没有影响，但是对参数有影响
interface Z1 extends X,Y{}