package collection.practice;

public class BosiCat extends Cat{
    @Override
    public void eat() {
        System.out.println("一直叫"+this.getName()+"的"+this.getAge()+"岁的波斯猫正在吃小饼干");
    }

    public BosiCat() {
    }

    public BosiCat(String name, int age) {
        super(name, age);
    }
}
