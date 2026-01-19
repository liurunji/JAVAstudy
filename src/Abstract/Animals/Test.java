package Abstract.Animals;

public class Test {
    public static void main(String[] args) {
        Frog f = new Frog("小青蛙",2);
        f.eat();

        Animal a = new Dog("小狗",3);
        a.drink();
        a.eat();
    }
}
