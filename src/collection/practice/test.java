package collection.practice;

import java.util.ArrayList;
import java.util.function.Consumer;

public class test {
    public static void main(String[] args) {
        //测试类中定义一个方法用于饲养动物
        //public static void keepPet(ArrayList<???> 1ist){
        // 遍历集合，调用动物的eat方法
        //}
        //要求1:该方法能养所有品种的猫，但是不能养狗
        //要求2:该方法能养所有品种的狗，但是不能养猫要求
        //3:该方法能养所有的动物，但是不能传递其他类型
        ArrayList<Cat> list1 = new ArrayList<>();
        BosiCat bs1 = new BosiCat("波斯", 2);
        LihuaCat lh1 = new LihuaCat("狸花", 3);
        list1.add(bs1);
        list1.add(lh1);
        keepPet1(list1);

        System.out.println("------------------------------------");

        ArrayList<Dog> list2 = new ArrayList<>();
        HashiQiDog ha1 = new HashiQiDog("二哈",3);
        TaidiDog td1 = new TaidiDog("泰迪",4);
        list2.add(ha1);
        list2.add(td1);
        keepPet2(list2);

        System.out.println("------------------------------------");

        keepPet3(list1);
        keepPet3(list2);


    }

    //要求1:该方法能养所有品种的猫，但是不能养狗
    public static void keepPet1(ArrayList<? extends Cat> list) {
        // 遍历集合，调用动物的eat方法
        list.forEach(cat -> cat.eat());
    }

    //要求2:该方法能养所有品种的狗，但是不能养猫要求
    public static void keepPet2(ArrayList<? extends Dog> list){
        // 遍历集合，调用动物的eat方法
        for (Dog dog : list) {
            dog.eat();
        }
    }

    //3:该方法能养所有的动物，但是不能传递其他类型
    public static void keepPet3(ArrayList<? extends Animal> list){
        // 遍历集合，调用动物的eat方法
        for (Animal animal : list) {
            animal.eat();
        }
    }
}
