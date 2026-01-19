import java.util.StringJoiner;

public class PinJieZiFuChuan {
    public static void main(String[] args) {
        //定义一个方法，把 int数组中的数据按照指定的格式拼接成一个字符串返回
        // 调用该方法，并在控制台输出结果。
        //例如:
        //数组为 int[] arr = {1,2,3};
        //执行方法后的输出结果为:[1，2，3]
        int[] arr = {1, 2, 3};
        String str1 = combineString(arr);
        System.out.println(str1);

        String str2 = combineIntToString(arr);
        System.out.println(str2);

        sjToString(arr);
    }

    //方法1
    public static String combineString(int[] arr) {
        if (arr == null)
            return "";
        if (arr.length == 0)
            return "[]";

        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                str = str + arr[i] + ',';
            }
            if (i == arr.length - 1) {
                str = str + arr[i] + ']';
            }
        }
        return str;
    }

    //方法2：使用stringbuilder
    public static String combineIntToString(int[] arr){
        if (arr == null)
            return "";
        if (arr.length == 0)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length-1){
                sb.append(arr[i]);
            }else {
                sb.append(arr[i]).append(",");
            }

        }
        sb.append("]");
        String str = sb.toString();
        return str;
    }

    //方法3：使用sStringJoiner
    public static void sjToString(int[] arr){
        StringJoiner sj = new StringJoiner(",","[","]");
        sj.add("1").add("2").add("3");
        String str = sj.toString();
        System.out.println(str);
    }

}
