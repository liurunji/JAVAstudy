package Extends.Dog;

public class Test {
    public static void main(String[] args) {
        HaShiQi haShiQi = new HaShiQi();
        haShiQi.destroyHome();
        haShiQi.drink();
        haShiQi.home();
        haShiQi.eat();
        System.out.println("----------------");

        ShaPiDog s = new ShaPiDog();
        s.eat();


    }
}
