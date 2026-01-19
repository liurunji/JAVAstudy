package pokerGame.doudizhu1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class PokerGame {
    /*
    1.准备牌
    2.洗牌
    3.发牌
    4.排序
     */

    static ArrayList<String> list = new ArrayList<>();

    //1.准备牌可以写成静态代码块，随着类的加载而加载，且只加载一次
    static {
        String[] color = {"♠", "♥", "♣", "♦"};
        String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String s : color) {
            for (String n : number) {
                list.add(s + n + " ");
            }
        }
        list.add("小王");
        list.add("大王");
        System.out.println(list);
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

        //看牌
        lookPoker("底牌", lord);
        lookPoker("地主", player1);
        lookPoker("农民1", player2);
        lookPoker("农民2", player3);

    }

    //看每个人的牌
    private void lookPoker(String name, ArrayList<String> poker) {
        System.out.print(name + ":");
        poker.forEach((String s) -> System.out.print(s + " "));
        System.out.println();
    }
}
