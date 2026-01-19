package pokerGame.doudizhu2;

import java.util.*;

public class PokerGame {
    /*
    1.准备牌
    2.洗牌
    3.发牌
    4.排序
     */


    //准备牌可以用hashMap,键是序号，值是花色+牌号  eg：<1,♥3>，这里不用做排序，因此选用hashmap效率高，可不用treemap
    static HashMap<Integer, String> hm = new HashMap<>();
    //list集合存储序号
    static ArrayList<Integer> list = new ArrayList<>();

    //1.准备牌可以写成静态代码块，随着类的加载而加载，且只加载一次
    static {
        String[] color = {"♠", "♥", "♣", "♦"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int serialNumber = 1;   //序列号从1开始
        for (String n : number) {
            for (String c : color) {   //以4张3，4张4，……4张K，排列
                //System.out.print(c+n+" ");
                //♠3 ♥3 ♣3 ♦3 ♠4 ♥4 ♣4 ♦4 ♠5 ♥5 ♣5 ♦5 ♠6 ♥6 ♣6 ♦6 ♠7 ♥7 ♣7 ♦7 ♠8 ♥8 ♣8 ♦8 ♠9 ♥9 ♣9 ♦9 ♠10 ♥10 ♣10 ♦10 ♠J ♥J ♣J ♦J ♠Q ♥Q ♣Q ♦Q ♠K ♥K ♣K ♦K ♠A ♥A ♣A ♦A ♠2 ♥2 ♣2 ♦2
                //1   2  3  4  5   6  7  8……………………………………………………………………………………
                list.add(serialNumber);   //把序号存入到list集合中
                hm.put(serialNumber, c + n); //把序号和牌号花色存到map双列集合中
                serialNumber++;   //序列号自增
            }
        }
        //把大小王加进集合
        list.add(serialNumber);
        hm.put(serialNumber, "小王");
        serialNumber++;
        list.add(serialNumber);
        hm.put(serialNumber, "大王");
        //System.out.println(list);
        //System.out.println(hm);
    }

    public PokerGame() {
        //洗牌:就是把存储序号的list集合打乱
        Collections.shuffle(list);
        //发牌
        //这里选用了treeSet来存储玩家的牌的序号值，因为treeSet自带排序功能，我们把打乱后list集合的序号值加到下面的treeSet集合后自动就能排好序
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            int serialNumber = list.get(i);
            if (i <= 2) {
                lord.add(serialNumber);
                continue;
            }
            if (i % 3 == 0) {
                player1.add(serialNumber);
            } else if (i % 3 == 1) {
                player2.add(serialNumber);
            } else {
                player3.add(serialNumber);
            }
        }

        System.out.println(lord);
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        //看牌
        lookPoker("地主底牌",lord);
        lookPoker("玩家1",player1);
        lookPoker("玩家2",player2);
        lookPoker("玩家3",player3);
    }

    private void lookPoker(String name, TreeSet<Integer> serialNumberList) {
        System.out.print(name+"：");
        //根据每个人treeSet里的序号去hashmap中查找对应的键值（牌）
        for (Integer serialNumber : serialNumberList) {
            String poker = hm.get(serialNumber);
            System.out.print(poker+" ");
        }
        System.out.println();
    }

}
