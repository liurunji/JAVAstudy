package algorithm.search;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 12, 17, 24, 33, 48, 51, 55, 64, 69, 72};

        System.out.println("请输入要查找的数字");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int num = Integer.parseInt(s);

        int index = binarySearch(arr, num);
        if (index < 0) {
            System.out.println("该数字不存在");
        }else {
            System.out.println("数字在数组中的索引是"+index);
        }

    }

    private static int binarySearch(int[] arr, int num) {
        for (int min = 0, max = arr.length - 1; min <= max; ) {
            int mid = (min + max) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (num > arr[mid]) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return -1;
    }

}
