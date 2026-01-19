public class StringMultiplication {
    public static void main(String[] args) {
        /*给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
          注意:需要用己有的知识完成。*/
        String num1 = "125", num2 = "1234";
        int n1 = getIntNumber(num1);
        int n2 = getIntNumber(num2);
        int result = n1 * n2;   //154250

        String finalResult = InttoString(result);
        System.out.println(finalResult);
    }

    public static int getIntNumber(String str) {
        char[] arr = str.toCharArray();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result * 10 + (arr[i] - '0');
        }
        return result;
    }

    public static String InttoString(int number) {   //154250
        //辗转相除得到每一位直接进行拼接
        String result = "";
        while (number > 0) {
            int ge = number % 10;
            result = ge + result;
            number = number / 10;
        }
        return result;
    }
}
