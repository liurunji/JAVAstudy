package ArrayList.Phone;

import java.util.ArrayList;

/*
需求:
定义javabean类:PhopePhone属性:品牌，价格。
main方法中定义一个集合，存入三个手机对象。分别为:小米，1000。苹果，8000。锤子2999.
定义一个方法，将价格低于3000的手机信息返回
*/
public class PhoneTest {
    public static void main(String[] args) {
        ArrayList<Phone> list = new ArrayList<>();
        Phone p1 = new Phone("小米",1000);
        Phone p2 = new Phone("苹果",8000);
        Phone p3 = new Phone("锤子",2999);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        ArrayList<Phone> Phonelist = PhoneInfo(list);
        for (int i = 0; i < Phonelist.size(); i++) {
            System.out.println("品牌："+Phonelist.get(i).getBrand()+",价格："+Phonelist.get(i).getPrice());
        }
    }

    public static ArrayList<Phone> PhoneInfo(ArrayList<Phone> list){
        ArrayList<Phone> phoneList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice()<3000){
                phoneList.add(list.get(i));
            }
        }
        return phoneList;
    }
}
