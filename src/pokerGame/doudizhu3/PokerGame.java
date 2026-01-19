package pokerGame.doudizhu3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame {
    /*
    1.准备牌
    2.洗牌
    3.发牌
    4.排序
     */

    //list存储花色和牌号
    static ArrayList<String> list = new ArrayList<>();
    //hashmap来存储牌对应的价值
    static HashMap<String, Integer> hm = new HashMap<>();

    //1.准备牌可以写成静态代码块，随着类的加载而加载，且只加载一次
    static {
        String[] color = {"♠", "♥", "♣", "♦"};
        String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String s : color) {
            for (String n : number) {
                list.add(s + n );
            }
        }
        list.add(" 小王");
        list.add(" 大王");
        System.out.println(list);

        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("小王", 16);   //大小王开头以空格代替花色，方便后续截取
        hm.put("大王", 17);
    }

    public PokerGame() {
        //洗牌
        Collections.shuffle(list);
        System.out.println(list);
        //发牌
        //准备4套：地主牌 地主 农民1 农民2
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);
            if (i <= 2) {
                //前三张牌当做底牌（地主牌）
                lord.add(poker);
                continue;
            }
            //剩下的牌发给三位玩家
            if (i % 3 == 0) {
                player1.add(poker);
            } else if (i % 3 == 1) {
                player2.add(poker);
            } else {
                player3.add(poker);
            }
        }

        //排序
        order(lord);
        order(player1);
        order(player2);
        order(player3);


        //看牌
        lookPoker("底牌", lord);
        lookPoker("地主", player1);
        lookPoker("农民1", player2);
        lookPoker("农民2", player3);

    }

    private void order(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //o1:当前元素  o2:已经有序元素
                String color1 = o1.substring(0, 1);  //索引0的位置是花色
                int value1 = getValue(o1);  //得到o1对应的价值
                String color2 = o2.substring(0, 1);
                int value2 = getValue(o2);

                int i = value1 - value2;   //按照牌价值进行排列
                i = i == 0 ? color1.compareTo(color2) : i;  //牌价值一样大，按照花色排序  即红桃三 黑桃三牌面一样大，按花色再排序
                return i;
            }
        });
    }

    private int getValue(String poker) {
        //截取除花色以外的所有字符，即牌的大小
        String number = poker.substring(1);
        if (hm.containsKey(number)) {
            //hashmap存在这个牌，找到对应的值（价值）
            return hm.get(number);
        } else {
            //不存在即3-10，那牌的大小即其价值
            return Integer.parseInt(number);
        }

    }

    //看每个人的牌
    private void lookPoker(String name, ArrayList<String> poker) {
        System.out.print(name + ":");
        poker.forEach((String s) -> System.out.print(s + " "));
        System.out.println();
    }
}
