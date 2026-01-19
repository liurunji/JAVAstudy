package collection.comprehensiveExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Demo2 {
    public static void main(String[] args) {
        /*
        班级里有N个学生
        要求:
        被点到的学生不会再被点到。
        但是如果班级中所有的学生都点完了需要重新开启第二轮点名
         */
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "亚托克斯", "德莱文", "嘉文", "盖伦", "劫", "艾希", "安妮", "黛安娜", "菲奥娜", "金克丝");

        ArrayList<String> tempList = new ArrayList<>();

        int length = list.size();  //记录集合的长度，要不然直接在循环中用list.size()会一直变
        Random r = new Random();

        for (int j = 0; j < 5; j++) {
            System.out.println("---------这是第" + (j + 1)+ "轮点名-----------");
            for (int i = 0; i < length; i++) {
                int index = r.nextInt(list.size());
                String name = list.remove(index);
                System.out.println(name);
                list.remove(name);
                //System.out.println(list);
                tempList.add(name);
            }
            list.addAll(tempList);
            tempList.clear();    //必须清空tempList，要不然会一直继续往里添加，导致重复
            //System.out.println(list);
            //System.out.println(tempList);
        }


    }
}
