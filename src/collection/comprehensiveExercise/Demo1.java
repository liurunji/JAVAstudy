package collection.comprehensiveExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Demo1 {
    public static void main(String[] args) {
        /*
        班级里有N个学生
        要求:70%的概率随机到男生
            30%的概率随机到女生
         */

        ArrayList<Integer> list = new ArrayList<>();
        //利用1和0来模拟70%和30%的概率
        Collections.addAll(list, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0);
        System.out.println(list);
        //打乱 随机
        Random r = new Random();
        int index = r.nextInt(list.size());    //获取一个随机的索引
        int number = list.get(index);   //获取到随机索引上的元素
        System.out.println(number);

        ArrayList<String> manList = new ArrayList<>();
        ArrayList<String> womenList = new ArrayList<>();
        Collections.addAll(manList, "亚托克斯", "德莱文", "嘉文", "盖伦", "劫", "赫卡里姆", "科加斯");
        Collections.addAll(womenList, "阿狸", "艾希", "安妮", "黛安娜", "菲奥娜", "金克丝", "卡莎");
        if (number == 1) {
            //如果是1，找到男生随机一个
            int manIndex = r.nextInt(manList.size());
            String man = manList.get(manIndex);
            System.out.println(man);
        } else {
            //如果是0，找到随机一个女生
            int womenIndex = r.nextInt(womenList.size());
            String woman = womenList.get(womenIndex);
            System.out.println(woman);
        }


    }
}
