package collection.practice;

public class HashiQiDog extends Dog{
    public HashiQiDog() {
    }

    public HashiQiDog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做"+this.getName()+"的"+this.getAge()+"岁的哈士奇正在啃骨头，边啃边拆家");
    }
}
