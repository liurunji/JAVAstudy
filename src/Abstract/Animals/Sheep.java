package Abstract.Animals;

public class Sheep extends Animal{
    @Override
    public void eat() {
        System.out.println("羊吃草");
    }

    public Sheep() {
    }

    public Sheep(String name, int age) {
        super(name, age);
    }
}
