public class IDCardInformation {
    public static void main(String[] args) {
        String IDcard = "370214200106263538";
        String born = IDcard.substring(6, 14);   //20010626

        String result = "";
        for (int i = 0; i < born.length(); i++) {

            if (i == 3) {
                result = result + born.charAt(i) + "年";
            } else if (i == 5) {
                result = result + born.charAt(i) + "月";
            } else if (i == 7) {
                result = result + born.charAt(i) + "日";
            } else {
                result = result + born.charAt(i);
            }

        }

        System.out.println("人物信息为：");
        System.out.println("出生年月日:" + result);

        char seventeen = IDcard.charAt(16);
        if ((seventeen - 48) % 2 == 1) {
            System.out.println("性别为：男");
        } else {
            System.out.println("性别为：女");
        }


    }
}
