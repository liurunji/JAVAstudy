import java.util.Random;

public class GenerateVerificationCode {
    public static void main(String[] args) {
        //生成验证码
        //内容：可以是小写字母，也可以是大写字母，还可以是数字
        //规则：
        //  	长度为5
        //  	内容中是四位字母，1位数字。
        //  	其中数字只有1位，但是可以出现在任意的位置。
        char[] ch = new char[52];
        //数组存储26个英文字母的大小写
        for (int i = 0; i < ch.length; i++) {
            if (i>=0&&i<=25){
                ch[i] =(char)('a' + i );
            }else {
                ch[i] =(char)('A' + i -26);
            }
        }

        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0;i<4;i++){
            int randomIndex = r.nextInt(ch.length);
            sb.append(ch[randomIndex]);
        }
        sb.append(r.nextInt(10));
        String str = sb.toString();
        char[] resultArr = str.toCharArray();
        for (int i = 0; i < resultArr.length; i++) {
            int randomIndex = r.nextInt(resultArr.length);
            char temp = resultArr[randomIndex];
            resultArr[randomIndex] = resultArr[i];
            resultArr[i] = temp;
        }

          /*StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < resultArr.length; i++) {
            sb1.append(resultArr[i]);
        }
        String result = sb1.toString();

        System.out.println(result);*/

        String verificationCode = new String(resultArr);
        System.out.println(verificationCode);


    }
}
