package collection.practice;

public class TaidiDog extends Dog{
    @Override
    public void eat() {
        System.out.println("一只叫做"+this.getName()+"的"+this.getAge()+"岁的泰迪狗正在啃骨头，边啃边蹭");
    }

    public TaidiDog() {
    }

    public TaidiDog(String name, int age) {
        super(name, age);
    }
}
