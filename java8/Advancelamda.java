package java8;
//lamda表达式用法
public class Advancelamda {
   private static void engine(Calculator calculator){   //直接调用要用静态
       int x=4,y=6;
       int result=calculator.calculate(x,y);
       System.out.println(result);
   }


//    private  static void engine(Calculator calculator){    //接口只有一个方法为函数式接口，可作为参数
//        int x=2,y=4;
//        //int result=
//        calculator.calculate(x,y);
//        System.out.println( calculator.calculate(x,y));
//    }
    private  static Calculator fire(){
        return  (x,y)->x%y;
    }
    public static void main(String[] args) {
        engine((x,y)->x+y);
        engine((x,y)->x-y);
        engine((x,y)->x*y);
        engine((x,y)->x/y);
        System.out.println(fire().calculate(2,2));
    }
}
