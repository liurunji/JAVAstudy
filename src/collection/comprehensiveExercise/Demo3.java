package collection.comprehensiveExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Demo3 {
    public static void main(String[] args) {
        /*
        需求定义一个Map集合，键用表示省份名称province，值表示市city，但是市会有多个添加完毕后，遍历结果格式如下:
        江苏省=南京市，扬州市，苏州市，无锡市，常州市
        湖北省 =武汉市，孝感市，十堰市，宜昌市，鄂州市
        河北省 =石家庄市，唐山市，邢台市，保定市，张家口市
         */

        ArrayList<String> city1 = new ArrayList<>();
        Collections.addAll(city1, "南京市", "扬州市", "苏州市", "无锡市", "常州市");
        ArrayList<String> city2 = new ArrayList<>();
        Collections.addAll(city2, "武汉市", "孝感市", "十堰市", "宜昌市", "鄂州市");
        ArrayList<String> city3 = new ArrayList<>();
        Collections.addAll(city3, "石家庄市", "唐山市", "邢台市", "保定市", "张家口市");


        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        hm.put("江苏省", city1);
        hm.put("湖北省", city2);
        hm.put("河北省", city3);

        System.out.println(hm);

        //遍历
        //两层遍历
        /*
         hm.forEach(new BiConsumer<String, ArrayList<String>>() {
            @Override
            public void accept(String key, ArrayList<String> value) {
                StringJoiner sj = new StringJoiner(",","","");
                value.forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        sj.add(s);
                    }
                });
                System.out.println(key + " = " + sj);
            }
        });
         */

        //简化lambda表达式
        hm.forEach((key, value) -> {
            StringJoiner sj = new StringJoiner(",", "", "");
            value.forEach(s -> sj.add(s));
            System.out.println(key + " = " + sj);
        });


    }
}
