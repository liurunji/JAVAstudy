package collection.map.treeMap;

import java.util.TreeMap;

public class Count {
    public static void main(String[] args) {
        /*
        需求:
        字符串“aababcabcdabcde”请统计字符串中每一个字符出现的次数，
        并按照以下格式输出输出结果:
        a(5)b(4)c(3)d(2)e(1)
         */

        String s = "ccccbbbaaa";
        TreeMap<Character, Integer> tm = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tm.containsKey(c)) {
                //存在
                Integer count = tm.get(c);  //取出键（字符）对应的值（次数）
                count++;    //次数自增
                tm.put(c, count);  //覆盖
            } else {
                //不存在
                tm.put(c, 1);  //不存在就添加一条新的，次数设为1
            }
        }

        System.out.println(tm);

        StringBuilder sb = new StringBuilder();

        tm.forEach((key, value) -> sb.append(key).append("(").append(value).append(")"));

        System.out.println(sb);
    }
}
