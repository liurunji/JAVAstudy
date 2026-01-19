package collection.practice;

public class LihuaCat extends Cat{
    public LihuaCat() {
    }

    public LihuaCat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做"+this.getName()+"的"+this.getAge()+"岁的狸花猫正在吃鱼");
    }
}
