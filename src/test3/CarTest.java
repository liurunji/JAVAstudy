package test3;

import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {
        //创建一个数组来存放3个对象
        Car[] arr = new Car[3];

        for (int i = 0; i < arr.length; i++) {
            Scanner sc = new Scanner(System.in);
            Car car = new Car();

            System.out.println("请输入品牌的名称：");
            String brand = sc.next();
            car.setBrand(brand);

            System.out.println("请输入价格：");
            int price = sc.nextInt();
            car.setPrice(price);

            System.out.println("请输入其颜色：");
            String color = sc.next();
            car.setColor(color);

            arr[i] = car;
        }

        for (int i = 0; i < arr.length; i++) {
            /*
            Car car = arr[i];
            System.out.println("品牌是"+car.getBrand()+"，价格是"+car.getPrice()+"，颜色是"+car.getColor());
             */

            System.out.println("品牌是" + arr[i].getBrand() + "，价格是" + arr[i].getPrice() + "，颜色是" + arr[i].getColor());

        }

    }
}
