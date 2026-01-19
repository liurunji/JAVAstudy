package Abstract.Sport;

public class Test {
    public static void main(String[] args) {
        PingPngPlayer pp = new PingPngPlayer("张三",25);
        pp.speak();
        pp.study();
        System.out.println(pp.getAge()+","+pp.getName());
    }
}
