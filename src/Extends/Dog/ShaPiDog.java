package Extends.Dog;

public class ShaPiDog extends Dog{
    @Override
    public void eat(){
        super.eat();
        System.out.println("shapi吃骨头");
    }
}
