public class Factorial {
    public static void main(String[] args) {
        //阶乘：  5！=5*4*3*2*1
        System.out.println(fac(5));
    }

    public static int fac(int num) {
        if (num == 0) {
            return 1;
        }
        if (num == 1) {
            return 1;
        }
        return num * fac(num - 1);
    }
}
