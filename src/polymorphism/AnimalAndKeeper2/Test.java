package polymorphism.AnimalAndKeeper2;

public class Test {
    public static void main(String[] args) {
        Person p = new Person("老王",30);
        Animal a = new Cat(2,"黑色");
        p.keepPet(a,"小鱼干");
    }


}
