package polymorphism.AnimalAndKeeper;

public class Test {
    public static void main(String[] args) {
        Keeper k1 = new Keeper(30,"老王");
        Dog dog = new Dog(2,"黑色");
        k1.keepPet(dog,"骨头");

        System.out.println("------------------------------");

        Keeper k2 = new Keeper(25,"老李");
        Cat cat = new Cat(3,"灰色");
        k2.keepPet(cat,"鱼");
        System.out.println("------------------------------");

        Animal a = new Dog(10,"huang色");
        k1.keepPet(a,"goushi ");


        //	5.思考：
        //	1.Dog和Cat都是Animal的子类，以上案例中针对不同的动物，定义了不同的keepPet方法，
        //	过于繁琐，能否简化，并体会简化后的好处？
        //	2.Dog和Cat虽然都是Animal的子类，但是都有其特有方法，能否想办法在keepPet中调用特有方法？
    }
}
