package java8;


  abstract class Animal{
    public abstract void noise();
}
class Dog extends Animal{
    public void noise() {
        System.out.println("wowo");
    }
    public void tail(){}
}
class  Cat extends  Animal{
    public void noise() {
        System.out.println("miao");
    }
    public void  pow(){};
}
public class DC extends  Animal{
      Dog dog=new Dog();    //多继承解决
      Cat cat=new Cat();
    public static void main(String[] args) {
        Animal animal=new DC();
        animal.noise();
    }
      public void noise(){
          dog.noise();
          cat.noise();
      }

}
