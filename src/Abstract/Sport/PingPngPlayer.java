package Abstract.Sport;

public class PingPngPlayer extends Athlete implements SpeakEnglish {
    public PingPngPlayer() {
    }

    public PingPngPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("练习乒乓球");
    }


    @Override
    public void speak() {
        System.out.println("乒乓球运动员要学英语");
    }
}
