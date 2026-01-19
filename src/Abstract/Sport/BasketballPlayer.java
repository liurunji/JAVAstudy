package Abstract.Sport;

public class BasketballPlayer extends Athlete{
    @Override
    public void study() {
        System.out.println("篮球运动员学习篮球");
    }

    public BasketballPlayer() {
    }

    public BasketballPlayer(String name, int age) {
        super(name, age);
    }
}
