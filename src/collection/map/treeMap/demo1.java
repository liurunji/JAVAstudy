package collection.map.treeMap;

import java.util.TreeMap;

public class demo1 {
    public static void main(String[] args) {
        /*
        TreeMap集合:基本应用
        需求1:
        键:整数表示id
        值:字符串表示商品名称
        要求1:按照id的升序排列
        要求2:按照id的降序排列
         */

        //按照键降序排列
        TreeMap<Integer, String> tm = new TreeMap<>((o1, o2) -> o2 - o1);
        tm.put(1, "康师傅");
        tm.put(2, "武大郎烧饼");
        tm.put(3, "西门庆包子");
        tm.put(4, "薯片");


        //默认按照键升序排列，按自己规则则需要实现comparator接口

        System.out.println(tm);


    }
}
