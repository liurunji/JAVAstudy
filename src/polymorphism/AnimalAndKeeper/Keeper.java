package polymorphism.AnimalAndKeeper;

public class Keeper {
    private int age;
    private String name;

    public Keeper() {
    }

    public Keeper(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void keepPet(Dog dog, String something) {
        System.out.println("年龄为" + this.age + "岁的" + this.name + "养了一只" + dog.getColor() + dog.getAge() + "岁的狗");
        dog.eat(something);
    }

    public void keepPet(Cat cat, String something) {
        System.out.println("年龄为" + this.age + "岁的" + this.name + "养了一只" + cat.getColor() + cat.getAge() + "岁的猫");
        cat.eat(something);
    }

    public void keepPet(Animal a,String something){
        if (a instanceof Dog){
            Dog d = (Dog)a;
            System.out.println("年龄为" + this.age + "岁的" + this.name + "养了一只" + d.getColor() + d.getAge() + "岁的狗");
            d.eat(something);
        } else if (a instanceof Cat) {
            Cat c = (Cat) a;
            System.out.println("年龄为" + this.age + "岁的" + this.name + "养了一只" + c.getColor() + c.getAge() + "岁的猫");
            c.eat(something);
        }
    }
}
