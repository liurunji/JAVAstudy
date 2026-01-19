public class RotatingString {
    public static void main(String[] args) {
        //给定两个字符串,A 和 B。
        // A 的旋转操作就是将 A最左边的字符移动到最右边。
        // 例如,若 A='abcde'，在移动一次之后结果就是'bcdea'
        // 如果在若干次调整操作之后，A能变成B，那么返回True。
        // 如果不能匹配成功，则返回false
        String A = "abcde",B = "cdeab";

        boolean flag = rotateString(A,B);
        if (flag){
            System.out.println("匹配成功");
        }else {
            System.out.println("匹配失败");
        }

    }

    public static boolean rotateString(String A,String B){
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(0);
            String temp = A.substring(1);
            A = temp +c;
            System.out.println(A);
            if (A.equals(B)){
                return true;
            }
        }
        return false;
    }
}
